package com.toky.bibliotheque.e2e;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests end-to-end : un vrai navigateur pilote l'application.
 * Prérequis : le codeserver GWT et Jetty doivent être lancés (http://localhost:8080/).
 */
class BibliothequeE2ETest {

    private static final String URL = "http://localhost:8080/";

    private static Playwright playwright;
    private static Browser browser;

    private BrowserContext context;
    private Page page;

    @BeforeAll
    static void lancerNavigateur() {
        playwright = Playwright.create();
        // -Dvisible=true pour voir le navigateur travailler (au ralenti)
        boolean visible = Boolean.getBoolean("visible");
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
            .setHeadless(!visible)
            .setSlowMo(visible ? 400 : 0));
        // La première compilation GWT peut être longue : on laisse du temps
        PlaywrightAssertions.setDefaultAssertionTimeout(60_000);
    }

    @AfterAll
    static void fermerNavigateur() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void ouvrirPage() {
        context = browser.newContext();
        page = context.newPage();
        page.setDefaultTimeout(60_000);
        page.navigate(URL);
        // On attend que l'application GWT soit chargée
        assertThat(bouton("Ajouter un livre")).isVisible();
    }

    @AfterEach
    void fermerPage() {
        context.close();
    }

    @Test
    @DisplayName("Parcours complet : ajouter, modifier puis supprimer un livre")
    void parcoursCompletCrud() {
        // Titre unique pour ne pas dépendre des données déjà en base
        String titre = "Livre E2E " + System.currentTimeMillis();
        String titreModifie = titre + " (modifié)";

        // 1) Ajout
        bouton("Ajouter un livre").click();
        page.locator("input[name=titre]").fill(titre);
        page.locator("input[name=auteur]").fill("Auteur de test");
        page.locator("input[name=annee]").fill("2024");
        bouton("Enregistrer").click();

        assertThat(ligne(titre)).hasCount(1);

        // 2) Modification
        ligne(titre).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Modifier")).click();
        assertThat(page.locator("input[name=titre]")).hasValue(titre); // formulaire prérempli
        page.locator("input[name=titre]").fill(titreModifie);
        bouton("Enregistrer").click();

        assertThat(ligne(titreModifie)).hasCount(1);

        // 3) Suppression : on accepte automatiquement la boîte "Supprimer ... ?"
        page.onDialog(dialog -> dialog.accept());
        ligne(titreModifie).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Supprimer")).click();

        assertThat(ligne(titreModifie)).hasCount(0);
    }

    @Test
    @DisplayName("Un formulaire vide affiche une erreur de validation")
    void formulaireVideAfficheUneErreur() {
        bouton("Ajouter un livre").click();
        bouton("Enregistrer").click();

        assertThat(page.getByText("Le titre est obligatoire.")).isVisible();

        bouton("Annuler").click();
    }

    // ===== Petites méthodes utilitaires =====

    private Locator bouton(String libelle) {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(libelle).setExact(true));
    }

    /** La ligne du tableau qui contient ce texte. */
    private Locator ligne(String texte) {
        return page.locator("tr", new Page.LocatorOptions().setHasText(texte));
    }
}
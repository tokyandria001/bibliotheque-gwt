package com.toky.bibliotheque;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Tests unitaires du presenter : la vue et le service sont remplacés par des mocks.
 * Aucun navigateur ni serveur n'est nécessaire.
 */
@ExtendWith(MockitoExtension.class)
class LivresPresenterTest {

    @Mock
    LivresPresenter.Display view;

    @Mock
    LivreServiceAsync service;

    // Permettent de "capturer" le callback passé au service, pour simuler la réponse du serveur
    @Captor
    ArgumentCaptor<AsyncCallback<List<Livre>>> callbackListe;

    @Captor
    ArgumentCaptor<AsyncCallback<Livre>> callbackAjout;

    private LivresPresenter presenter;

    @BeforeEach
    void setUp() {
        presenter = new LivresPresenter(view, service);
    }

    @Test
    @DisplayName("Le presenter s'enregistre auprès de la vue")
    void constructeurEnregistreLePresenter() {
        verify(view).setPresenter(presenter);
    }

    @Test
    @DisplayName("Au démarrage, les livres reçus du serveur sont affichés")
    void demarrerAfficheLesLivres() {
        List<Livre> livres = Arrays.asList(
            new Livre(1L, "Germinal", "Émile Zola", 1885, true));

        presenter.demarrer();

        // On récupère le callback envoyé au service et on simule la réponse du serveur
        verify(service).getLivres(callbackListe.capture());
        callbackListe.getValue().onSuccess(livres);

        verify(view).afficherLivres(livres);
    }

    @Test
    @DisplayName("Si le serveur échoue au chargement, un message d'erreur est affiché")
    void demarrerEnErreurAfficheUnMessage() {
        presenter.demarrer();

        verify(service).getLivres(callbackListe.capture());
        callbackListe.getValue().onFailure(new RuntimeException("Serveur indisponible"));

        verify(view).afficherMessage(contains("Serveur indisponible"));
    }

    @Test
    @DisplayName("Le clic sur Ajouter ouvre le formulaire")
    void ajouterOuvreLeFormulaire() {
        presenter.onAjouterClique();

        verify(view).ouvrirFormulaire();
    }

    @Test
    @DisplayName("Un livre invalide est refusé sans appeler le serveur")
    void livreInvalideNAppellePasLeServeur() {
        Livre sansTitre = new Livre(null, "", "Victor Hugo", 1831, true);

        presenter.onEnregistrer(sansTitre);

        verify(view).afficherErreurFormulaire("Le titre est obligatoire.");
        verify(service, never()).ajouterLivre(any(), any());
    }

    @Test
    @DisplayName("Un livre valide est envoyé, puis le formulaire se ferme et la liste est rechargée")
    void livreValideEstEnregistre() {
        Livre livre = new Livre(null, "Notre-Dame de Paris", "Victor Hugo", 1831, true);

        presenter.onEnregistrer(livre);

        verify(service).ajouterLivre(eq(livre), callbackAjout.capture());
        callbackAjout.getValue().onSuccess(livre);

        verify(view).fermerFormulaire();
        verify(service).getLivres(any());
    }

    @Test
    @DisplayName("Une erreur serveur à l'enregistrement est affichée dans le formulaire")
    void erreurServeurAffichee() {
        Livre livre = new Livre(null, "Notre-Dame de Paris", "Victor Hugo", 1831, true);

        presenter.onEnregistrer(livre);

        verify(service).ajouterLivre(eq(livre), callbackAjout.capture());
        callbackAjout.getValue().onFailure(new IllegalArgumentException("Erreur côté serveur"));

        verify(view).afficherErreurFormulaire("Erreur côté serveur");
        verify(view, never()).fermerFormulaire();
    }
}
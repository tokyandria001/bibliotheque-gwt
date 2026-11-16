package com.toky.bibliotheque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test d'intégration : vrai Hibernate + vraie base H2, mais EN MÉMOIRE
 * (recréée vide pour chaque test, la base de l'application n'est jamais touchée).
 */
class LivreRepositoryTest {

    private EntityManagerFactory emf;
    private LivreRepository repository;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("bibliotheque", Map.of(
            "jakarta.persistence.jdbc.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
            "hibernate.hbm2ddl.auto", "create-drop",
            "hibernate.show_sql", "false"
        ));
        repository = new LivreRepository(emf);
    }

    @AfterEach
    void tearDown() {
        emf.close();
    }

    @Test
    @DisplayName("La base est vide au départ")
    void baseVideAuDepart() {
        assertEquals(0, repository.compter());
        assertEquals(0, repository.trouverTous().size());
    }

    @Test
    @DisplayName("Ajouter un livre lui attribue un id et l'enregistre en base")
    void ajouterAttribueUnId() {
        Livre ajoute = repository.ajouter(new Livre(null, "Germinal", "Émile Zola", 1885, true));

        assertNotNull(ajoute.getId());
        assertEquals(1, repository.compter());
        assertEquals("Germinal", repository.trouverTous().get(0).getTitre());
    }

    @Test
    @DisplayName("Les livres sont renvoyés dans l'ordre d'ajout")
    void trouverTousRespecteLOrdre() {
        repository.ajouter(new Livre(null, "Livre A", "Auteur A", 2000, true));
        repository.ajouter(new Livre(null, "Livre B", "Auteur B", 2001, false));

        List<Livre> livres = repository.trouverTous();

        assertEquals(2, livres.size());
        assertEquals("Livre A", livres.get(0).getTitre());
        assertEquals("Livre B", livres.get(1).getTitre());
    }

    @Test
    @DisplayName("La liste renvoyée est une ArrayList (sérialisable par GWT-RPC)")
    void listeCompatibleGwtRpc() {
        assertEquals(ArrayList.class, repository.trouverTous().getClass());
    }

        @Test
    @DisplayName("Modifier un livre met à jour la base")
    void modifierMetAJour() {
        Livre ajoute = repository.ajouter(new Livre(null, "Titre initial", "Auteur", 2000, true));

        ajoute.setTitre("Titre modifié");
        ajoute.setDisponible(false);
        repository.modifier(ajoute);

        Livre relu = repository.trouverTous().get(0);
        assertEquals("Titre modifié", relu.getTitre());
        assertEquals(false, relu.isDisponible());
    }

    @Test
    @DisplayName("Supprimer un livre le retire de la base")
    void supprimerRetireLeLivre() {
        Livre ajoute = repository.ajouter(new Livre(null, "À supprimer", "Auteur", 2000, true));

        repository.supprimer(ajoute.getId());

        assertEquals(0, repository.compter());
    }
}
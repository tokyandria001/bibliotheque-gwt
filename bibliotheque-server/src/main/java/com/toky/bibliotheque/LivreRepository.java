package com.toky.bibliotheque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Accès à la base de données pour les livres (pattern Repository / DAO).
 */
public class LivreRepository {

    private final EntityManagerFactory emf;

    public LivreRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // ===== Lecture =====

    public List<Livre> trouverTous() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM LivreEntity l ORDER BY l.id", LivreEntity.class)
                     .getResultList()
                     .stream()
                     .map(LivreEntity::versDto)
                     // ArrayList explicite : GWT-RPC ne sait pas sérialiser les listes immuables (stream.toList())
                     .collect(Collectors.toCollection(ArrayList::new));
        } finally {
            em.close();
        }
    }

    public long compter() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT COUNT(l) FROM LivreEntity l", Long.class)
                     .getSingleResult();
        } finally {
            em.close();
        }
    }

    // ===== Écriture (toujours dans une transaction) =====

    public Livre ajouter(Livre livre) {
        return enTransaction(em -> {
            LivreEntity entite = LivreEntity.depuisDto(livre);
            em.persist(entite);
            return entite.versDto();
        });
    }

    public Livre modifier(Livre livre) {
        return enTransaction(em -> {
            LivreEntity entite = em.find(LivreEntity.class, livre.getId());
            if (entite == null) {
                throw new IllegalArgumentException("Livre introuvable (id " + livre.getId() + ").");
            }
            entite.mettreAJour(livre); // Hibernate détecte le changement et fait l'UPDATE au commit
            return entite.versDto();
        });
    }

    public void supprimer(Long id) {
        enTransaction(em -> {
            LivreEntity entite = em.find(LivreEntity.class, id);
            if (entite != null) {
                em.remove(entite);
            }
            return null;
        });
    }

    /**
     * Exécute une action dans une transaction : commit si tout va bien, rollback en cas d'erreur.
     * Évite de répéter le même try/catch/finally dans chaque méthode.
     */
    private <T> T enTransaction(Function<EntityManager, T> action) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            T resultat = action.apply(em);
            tx.commit();
            return resultat;
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
package com.toky.bibliotheque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Accès à la base de données pour les livres (pattern Repository / DAO).
 */
public class LivreRepository {

    private final EntityManagerFactory emf;

    // L'EntityManagerFactory est injectée : en test, on en passe une sur une base en mémoire
    public LivreRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Livre> trouverTous() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM LivreEntity l ORDER BY l.id", LivreEntity.class)
                     .getResultList()
                     .stream()
                     .map(LivreEntity::versDto)
                     // ArrayList explicite : GWT-RPC ne sait pas sérialiser les listes immuables de Java 17 (stream.toList())
                     .collect(Collectors.toCollection(ArrayList::new));
        } finally {
            em.close();
        }
    }

    public Livre ajouter(Livre livre) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            LivreEntity entite = LivreEntity.depuisDto(livre);
            em.persist(entite);
            tx.commit();
            return entite.versDto();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback(); // en cas d'erreur, on annule tout
            }
            throw e;
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
}
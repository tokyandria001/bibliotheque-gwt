package com.toky.bibliotheque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entité JPA : représente la table "livre" en base de données.
 * Utilisée UNIQUEMENT côté serveur. Le client reçoit des objets Livre (DTO).
 */
@Entity
@Table(name = "livre")
public class LivreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titre;

    @Column(nullable = false, length = 150)
    private String auteur;

    @Column(nullable = false)
    private int annee;

    @Column(nullable = false)
    private boolean disponible;

    /** Constructeur vide obligatoire pour JPA. */
    protected LivreEntity() {
    }

    /** DTO -> Entité (l'id est généré par la base). */
    public static LivreEntity depuisDto(Livre livre) {
        LivreEntity entite = new LivreEntity();
        entite.titre = livre.getTitre();
        entite.auteur = livre.getAuteur();
        entite.annee = livre.getAnnee();
        entite.disponible = livre.isDisponible();
        return entite;
    }

    /** Entité -> DTO (pour l'envoyer au client). */
    public Livre versDto() {
        return new Livre(id, titre, auteur, annee, disponible);
    }

    public Long getId() {
        return id;
    }
}
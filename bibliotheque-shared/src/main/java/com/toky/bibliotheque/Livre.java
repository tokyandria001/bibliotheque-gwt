package com.toky.bibliotheque; // ← même ligne package que GreetingService.java

import java.io.Serializable;

public class Livre implements Serializable {

    private Long id;
    private String titre;
    private String auteur;
    private int annee;
    private boolean disponible;

    // Constructeur vide OBLIGATOIRE pour GWT-RPC
    public Livre() {
    }

    public Livre(Long id, String titre, String auteur, int annee, boolean disponible) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.disponible = disponible;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
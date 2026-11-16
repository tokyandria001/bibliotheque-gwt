package com.toky.bibliotheque;

/**
 * Règles de validation d'un livre.
 * Placée dans "shared" : utilisée à la fois par le client ET par le serveur.
 */
public final class LivreValidator {

    private LivreValidator() {
    }

    /** @return un message d'erreur, ou null si le livre est valide */
    public static String valider(Livre livre) {
        if (livre.getTitre() == null || livre.getTitre().trim().isEmpty()) {
            return "Le titre est obligatoire.";
        }
        if (livre.getAuteur() == null || livre.getAuteur().trim().isEmpty()) {
            return "L'auteur est obligatoire.";
        }
        if (livre.getAnnee() < 1 || livre.getAnnee() > 2100) {
            return "L'année doit être comprise entre 1 et 2100.";
        }
        return null;
    }
}
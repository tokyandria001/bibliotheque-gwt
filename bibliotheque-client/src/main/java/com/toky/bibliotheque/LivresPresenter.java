package com.toky.bibliotheque;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

import java.util.List;

public class LivresPresenter {

    public interface Display extends IsWidget {
        void setPresenter(LivresPresenter presenter);
        void afficherLivres(List<Livre> livres);
        void afficherMessage(String message);
        boolean confirmer(String question);
        /** @param livre le livre à modifier, ou null pour un ajout */
        void ouvrirFormulaire(Livre livre);
        void fermerFormulaire();
        void afficherErreurFormulaire(String message);
    }

    private final Display view;
    private final LivreServiceAsync service;

    public LivresPresenter(Display view, LivreServiceAsync service) {
        this.view = view;
        this.service = service;
        this.view.setPresenter(this);
    }

    public void demarrer() {
        chargerLivres();
    }

    private void chargerLivres() {
        service.getLivres(new AsyncCallback<List<Livre>>() {
            @Override
            public void onSuccess(List<Livre> livres) {
                view.afficherLivres(livres);
            }

            @Override
            public void onFailure(Throwable erreur) {
                view.afficherMessage("Impossible de charger les livres : " + erreur.getMessage());
            }
        });
    }

    // ===== Actions de l'utilisateur =====

    public void onAjouterClique() {
        view.ouvrirFormulaire(null);
    }

    public void onModifierClique(Livre livre) {
        view.ouvrirFormulaire(livre);
    }

    public void onSupprimerClique(Livre livre) {
        if (!view.confirmer("Supprimer « " + livre.getTitre() + " » ?")) {
            return;
        }
        service.supprimerLivre(livre.getId(), new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void rien) {
                chargerLivres();
            }

            @Override
            public void onFailure(Throwable erreur) {
                view.afficherMessage("Suppression impossible : " + erreur.getMessage());
            }
        });
    }

    public void onEnregistrer(Livre livre) {
        String erreur = LivreValidator.valider(livre);
        if (erreur != null) {
            view.afficherErreurFormulaire(erreur);
            return;
        }

        AsyncCallback<Livre> callback = new AsyncCallback<Livre>() {
            @Override
            public void onSuccess(Livre resultat) {
                view.fermerFormulaire();
                chargerLivres();
            }

            @Override
            public void onFailure(Throwable erreur) {
                view.afficherErreurFormulaire(erreur.getMessage());
            }
        };

        // Pas d'id = nouveau livre ; sinon = modification
        if (livre.getId() == null) {
            service.ajouterLivre(livre, callback);
        } else {
            service.modifierLivre(livre, callback);
        }
    }
}
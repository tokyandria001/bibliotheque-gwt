package com.toky.bibliotheque;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

import java.util.List;

public class LivresPresenter {

    public interface Display extends IsWidget {
        void setPresenter(LivresPresenter presenter);
        void afficherLivres(List<Livre> livres);
        void afficherMessage(String message);
        void ouvrirFormulaire();
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

    public void onAjouterClique() {
        view.ouvrirFormulaire();
    }

    public void onEnregistrer(Livre livre) {
        // 1) Validation côté client : réponse immédiate, sans appel serveur
        String erreur = LivreValidator.valider(livre);
        if (erreur != null) {
            view.afficherErreurFormulaire(erreur);
            return;
        }

        // 2) Envoi au serveur
        service.ajouterLivre(livre, new AsyncCallback<Livre>() {
            @Override
            public void onSuccess(Livre ajoute) {
                view.fermerFormulaire();
                chargerLivres(); // on rafraîchit le tableau
            }

            @Override
            public void onFailure(Throwable erreur) {
                view.afficherErreurFormulaire(erreur.getMessage());
            }
        });
    }
}
package com.toky.bibliotheque;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

import java.util.List;

public class LivresPresenter {

    public interface Display extends IsWidget {
        void setPresenter(LivresPresenter presenter);
        void afficherLivres(List<Livre> livres);
        void afficherMessage(String message);
    }

    private final Display view;
    private final LivreServiceAsync service;

    // Le service est passé en paramètre : on pourra le remplacer par un faux dans les tests
    public LivresPresenter(Display view, LivreServiceAsync service) {
        this.view = view;
        this.service = service;
        this.view.setPresenter(this);
    }

    public void demarrer() {
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
        view.afficherMessage("Bientôt : le formulaire d'ajout !");
    }
}
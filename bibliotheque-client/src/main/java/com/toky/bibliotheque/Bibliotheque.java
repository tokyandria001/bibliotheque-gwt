package com.toky.bibliotheque;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Point d'entrée de l'application (l'équivalent du main).
 */
public class Bibliotheque implements EntryPoint {

    @Override
    public void onModuleLoad() {
        BibliothequeView view = new BibliothequeView();
        LivresPresenter presenter = new LivresPresenter(view);

        RootPanel.get().add(view);
        presenter.demarrer();
    }
}
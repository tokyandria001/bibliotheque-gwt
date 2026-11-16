package com.toky.bibliotheque;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class Bibliotheque implements EntryPoint {

    @Override
    public void onModuleLoad() {
        LivreServiceAsync service = GWT.create(LivreService.class);

        BibliothequeView view = new BibliothequeView();
        LivresPresenter presenter = new LivresPresenter(view, service);

        RootPanel.get().add(view);
        presenter.demarrer();
    }
}
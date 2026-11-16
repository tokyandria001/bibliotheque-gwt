package com.toky.bibliotheque;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface LivreServiceAsync {
    void getLivres(AsyncCallback<List<Livre>> callback);
    void ajouterLivre(Livre livre, AsyncCallback<Livre> callback);
}
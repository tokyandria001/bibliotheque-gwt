package com.toky.bibliotheque;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("livres")
public interface LivreService extends RemoteService {
    List<Livre> getLivres();
    Livre ajouterLivre(Livre livre) throws IllegalArgumentException;
    Livre modifierLivre(Livre livre) throws IllegalArgumentException;
    void supprimerLivre(Long id);
}
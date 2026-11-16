package com.toky.bibliotheque;

import com.google.gwt.user.server.rpc.jakarta.RemoteServiceServlet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Implémentation serveur du service des livres.
 * Pour l'instant les données sont stockées en mémoire (plus tard : base de données).
 */
@SuppressWarnings("serial")
public class LivreServiceImpl extends RemoteServiceServlet implements LivreService {

    // Liste thread-safe : plusieurs utilisateurs peuvent appeler le service en même temps
    private final List<Livre> livres = new CopyOnWriteArrayList<>();

    public LivreServiceImpl() {
        livres.add(new Livre(1L, "Le Petit Prince", "Antoine de Saint-Exupéry", 1943, true));
        livres.add(new Livre(2L, "L'Étranger", "Albert Camus", 1942, false));
        livres.add(new Livre(3L, "Les Misérables", "Victor Hugo", 1862, true));
        livres.add(new Livre(4L, "Germinal", "Émile Zola", 1885, true));
    }

    @Override
    public List<Livre> getLivres() {
        // On renvoie une copie : le client ne doit jamais modifier la liste du serveur
        return new ArrayList<>(livres);
    }
}
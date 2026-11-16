package com.toky.bibliotheque;

import com.google.gwt.user.server.rpc.jakarta.RemoteServiceServlet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Implémentation serveur du service des livres.
 * Pour l'instant les données sont stockées en mémoire (plus tard : base de données).
 */
@SuppressWarnings("serial")
public class LivreServiceImpl extends RemoteServiceServlet implements LivreService {

    private final List<Livre> livres = new CopyOnWriteArrayList<>();
    private final AtomicLong prochainId = new AtomicLong(5);

    public LivreServiceImpl() {
        livres.add(new Livre(1L, "Le Petit Prince", "Antoine de Saint-Exupéry", 1943, true));
        livres.add(new Livre(2L, "L'Étranger", "Albert Camus", 1942, false));
        livres.add(new Livre(3L, "Les Misérables", "Victor Hugo", 1862, true));
        livres.add(new Livre(4L, "Germinal", "Émile Zola", 1885, true));
    }

    @Override
    public List<Livre> getLivres() {
        return new ArrayList<>(livres);
    }

    @Override
    public Livre ajouterLivre(Livre livre) throws IllegalArgumentException {
        // Validation côté serveur (mêmes règles que côté client)
        String erreur = LivreValidator.valider(livre);
        if (erreur != null) {
            throw new IllegalArgumentException(erreur);
        }
        livre.setId(prochainId.getAndIncrement());
        livres.add(livre);
        return livre;
    }
}
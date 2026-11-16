package com.toky.bibliotheque;

import com.google.gwt.user.server.rpc.jakarta.RemoteServiceServlet;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

/**
 * Service RPC des livres : délègue l'accès aux données au LivreRepository.
 */
@SuppressWarnings("serial")
public class LivreServiceImpl extends RemoteServiceServlet implements LivreService {

    private EntityManagerFactory emf;
    private LivreRepository repository;

    /** Appelé une seule fois au démarrage du servlet. */
    @Override
    public void init() {
        emf = Persistence.createEntityManagerFactory("bibliotheque");
        repository = new LivreRepository(emf);

        // Données de départ si la base est vide
        if (repository.compter() == 0) {
            repository.ajouter(new Livre(null, "Le Petit Prince", "Antoine de Saint-Exupéry", 1943, true));
            repository.ajouter(new Livre(null, "L'Étranger", "Albert Camus", 1942, false));
            repository.ajouter(new Livre(null, "Les Misérables", "Victor Hugo", 1862, true));
            repository.ajouter(new Livre(null, "Germinal", "Émile Zola", 1885, true));
        }
    }

    /** Appelé à l'arrêt du serveur : on libère les connexions. */
    @Override
    public void destroy() {
        if (emf != null) {
            emf.close();
        }
        super.destroy();
    }

    @Override
    public List<Livre> getLivres() {
        return repository.trouverTous();
    }

    @Override
    public Livre ajouterLivre(Livre livre) throws IllegalArgumentException {
        String erreur = LivreValidator.valider(livre);
        if (erreur != null) {
            throw new IllegalArgumentException(erreur);
        }
        return repository.ajouter(livre);
    }

        @Override
    public Livre modifierLivre(Livre livre) throws IllegalArgumentException {
        if (livre.getId() == null) {
            throw new IllegalArgumentException("Impossible de modifier un livre sans identifiant.");
        }
        String erreur = LivreValidator.valider(livre);
        if (erreur != null) {
            throw new IllegalArgumentException(erreur);
        }
        return repository.modifier(livre);
    }

    @Override
    public void supprimerLivre(Long id) {
        repository.supprimer(id);
    }
}
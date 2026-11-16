package com.toky.bibliotheque;

import com.google.gwt.user.client.ui.IsWidget;

import java.util.Arrays;
import java.util.List;

/**
 * Presenter : contient la logique de l'écran "liste des livres".
 * Il ne connaît la vue qu'à travers l'interface Display.
 */
public class LivresPresenter {

    /** Contrat que la vue doit respecter. */
    public interface Display extends IsWidget {
        void setPresenter(LivresPresenter presenter);
        void afficherLivres(List<Livre> livres);
        void afficherMessage(String message);
    }

    private final Display view;

    public LivresPresenter(Display view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    /** Appelé au démarrage de l'écran. */
    public void demarrer() {
        // Données en dur pour l'instant : à l'étape 5, elles viendront du serveur
        List<Livre> livres = Arrays.asList(
            new Livre(1L, "Le Petit Prince", "Antoine de Saint-Exupéry", 1943, true),
            new Livre(2L, "L'Étranger", "Albert Camus", 1942, false),
            new Livre(3L, "Les Misérables", "Victor Hugo", 1862, true)
        );
        view.afficherLivres(livres);
    }

    /** Appelé par la vue quand l'utilisateur clique sur "Ajouter". */
    public void onAjouterClique() {
        view.afficherMessage("Bientôt : le formulaire d'ajout !");
    }
}
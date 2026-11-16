package com.toky.bibliotheque; // ← même package que votre classe EntryPoint

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class BibliothequeView extends Composite {

    // Lien entre ce fichier Java et BibliothequeView.ui.xml
    interface Binder extends UiBinder<Widget, BibliothequeView> {}
    private static final Binder BINDER = GWT.create(Binder.class);

    // Champs injectés depuis le XML (même nom que ui:field)
    @UiField CellTable<Livre> table;
    @UiField Button boutonAjouter;

    public BibliothequeView() {
        initWidget(BINDER.createAndBindUi(this));
        initColonnes();
        chargerLivres();
    }

    private void initColonnes() {
        ajouterColonne("Titre", Livre::getTitre);
        ajouterColonne("Auteur", Livre::getAuteur);
        ajouterColonne("Année", l -> String.valueOf(l.getAnnee()));
        ajouterColonne("Disponible", l -> l.isDisponible() ? "Oui" : "Non");
    }

    // Petite méthode utilitaire pour éviter de répéter les classes anonymes
    private void ajouterColonne(String entete, Function<Livre, String> valeur) {
        table.addColumn(new TextColumn<Livre>() {
            @Override
            public String getValue(Livre livre) {
                return valeur.apply(livre);
            }
        }, entete);
    }

    private void chargerLivres() {
        List<Livre> livres = Arrays.asList(
            new Livre(1L, "Le Petit Prince", "Antoine de Saint-Exupéry", 1943, true),
            new Livre(2L, "L'Étranger", "Albert Camus", 1942, false),
            new Livre(3L, "Les Misérables", "Victor Hugo", 1862, true)
        );
        table.setRowData(livres);
    }

    // Gestionnaire de clic déclaré par annotation
    @UiHandler("boutonAjouter")
    void onAjouter(ClickEvent event) {
        Window.alert("Bientôt : le formulaire d'ajout !");
    }
}
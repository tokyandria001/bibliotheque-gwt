package com.toky.bibliotheque;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Vue : uniquement de l'affichage. Aucune logique métier ici.
 */
public class BibliothequeView extends Composite implements LivresPresenter.Display {

    interface Binder extends UiBinder<Widget, BibliothequeView> {}
    private static final Binder BINDER = GWT.create(Binder.class);

    @UiField CellTable<Livre> table;
    @UiField Button boutonAjouter;

    private LivresPresenter presenter;
    private final LivreFormDialog formulaire = new LivreFormDialog();

    public BibliothequeView() {
        initWidget(BINDER.createAndBindUi(this));
        initColonnes();
    }

    private void initColonnes() {
        ajouterColonne("Titre", Livre::getTitre);
        ajouterColonne("Auteur", Livre::getAuteur);
        ajouterColonne("Année", l -> String.valueOf(l.getAnnee()));
        ajouterColonne("Disponible", l -> l.isDisponible() ? "Oui" : "Non");
        ajouterColonneBouton("Modifier", livre -> presenter.onModifierClique(livre));
        ajouterColonneBouton("Supprimer", livre -> presenter.onSupprimerClique(livre));
    }

    private void ajouterColonne(String entete, Function<Livre, String> valeur) {
        table.addColumn(new TextColumn<Livre>() {
            @Override
            public String getValue(Livre livre) {
                return valeur.apply(livre);
            }
        }, entete);
    }

    /** Colonne contenant un bouton : au clic, on appelle l'action avec le livre de la ligne. */
    private void ajouterColonneBouton(String libelle, Consumer<Livre> action) {
        Column<Livre, String> colonne = new Column<Livre, String>(new ButtonCell()) {
            @Override
            public String getValue(Livre livre) {
                return libelle;
            }
        };
        colonne.setFieldUpdater((index, livre, valeur) -> action.accept(livre));
        table.addColumn(colonne);
    }

    // ===== Implémentation de LivresPresenter.Display =====

    @Override
    public void setPresenter(LivresPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void afficherLivres(List<Livre> livres) {
        table.setRowData(livres);
    }

    @Override
    public void afficherMessage(String message) {
        Window.alert(message);
    }

    @Override
    public boolean confirmer(String question) {
        return Window.confirm(question);
    }

    @Override
    public void ouvrirFormulaire(Livre livre) {
        formulaire.ouvrir(livre, l -> presenter.onEnregistrer(l));
    }

    @Override
    public void fermerFormulaire() {
        formulaire.fermer();
    }

    @Override
    public void afficherErreurFormulaire(String message) {
        formulaire.afficherErreur(message);
    }

    // ===== Événements : on délègue au presenter =====

    @UiHandler("boutonAjouter")
    void onAjouter(ClickEvent event) {
        presenter.onAjouterClique();
    }
}
package com.toky.bibliotheque;

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

import java.util.List;
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
    }

    private void ajouterColonne(String entete, Function<Livre, String> valeur) {
        table.addColumn(new TextColumn<Livre>() {
            @Override
            public String getValue(Livre livre) {
                return valeur.apply(livre);
            }
        }, entete);
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
    public void ouvrirFormulaire() {
        formulaire.ouvrir(livre -> presenter.onEnregistrer(livre));
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
package com.toky.bibliotheque;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Boîte de dialogue de saisie d'un livre (composant de la vue).
 */
public class LivreFormDialog {

    interface Binder extends UiBinder<DialogBox, LivreFormDialog> {}
    private static final Binder BINDER = GWT.create(Binder.class);

    /** Appelé quand l'utilisateur clique sur "Enregistrer". */
    public interface Listener {
        void onEnregistrer(Livre livre);
    }

    @UiField TextBox champTitre;
    @UiField TextBox champAuteur;
    @UiField IntegerBox champAnnee;
    @UiField CheckBox champDisponible;
    @UiField Label messageErreur;
    @UiField Button boutonAnnuler;
    @UiField Button boutonEnregistrer;

    private final DialogBox dialog;
    private Listener listener;

    public LivreFormDialog() {
        dialog = BINDER.createAndBindUi(this);
    }

    public void ouvrir(Listener listener) {
        this.listener = listener;
        champTitre.setValue("");
        champAuteur.setValue("");
        champAnnee.setValue(null);
        champDisponible.setValue(true);
        messageErreur.setText("");
        dialog.center();
        champTitre.setFocus(true);
    }

    public void fermer() {
        dialog.hide();
    }

    public void afficherErreur(String message) {
        messageErreur.setText(message);
    }

    @UiHandler("boutonAnnuler")
    void onAnnuler(ClickEvent event) {
        fermer();
    }

    @UiHandler("boutonEnregistrer")
    void onEnregistrer(ClickEvent event) {
        Integer annee = champAnnee.getValue();
        Livre livre = new Livre(
            null,
            champTitre.getValue().trim(),
            champAuteur.getValue().trim(),
            annee == null ? 0 : annee,
            champDisponible.getValue()
        );
        listener.onEnregistrer(livre);
    }
}
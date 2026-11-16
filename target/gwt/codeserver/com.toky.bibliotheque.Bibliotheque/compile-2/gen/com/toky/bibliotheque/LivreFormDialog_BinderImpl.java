// .ui.xml template last modified: 1794850851552
package com.toky.bibliotheque;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.DialogBox;

public class LivreFormDialog_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.DialogBox, com.toky.bibliotheque.LivreFormDialog>, com.toky.bibliotheque.LivreFormDialog.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("Disponible")
    SafeHtml html1();
     
    @Template("Annuler")
    SafeHtml html2();
     
    @Template("Enregistrer")
    SafeHtml html3();
     
    @Template("<div class='{0}'> <span class='{1}'>Titre</span> <span id='{2}'></span> </div> <div class='{3}'> <span class='{4}'>Auteur</span> <span id='{5}'></span> </div> <div class='{6}'> <span class='{7}'>Année</span> <span id='{8}'></span> </div> <div class='{9}'> <span id='{10}'></span> </div> <span id='{11}'></span> <div class='{12}'> <span id='{13}'></span> <span id='{14}'></span> </div>")
    SafeHtml html4(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.DialogBox createAndBindUi(final com.toky.bibliotheque.LivreFormDialog owner) {


    return new Widgets(owner).get_f_DialogBox1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.toky.bibliotheque.LivreFormDialog owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAnnuler((com.google.gwt.event.dom.client.ClickEvent) event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onEnregistrer((com.google.gwt.event.dom.client.ClickEvent) event);
      }
    };

    public Widgets(final com.toky.bibliotheque.LivreFormDialog owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4("" + get_style().ligne() + "", "" + get_style().etiquette() + "", get_domId0(), "" + get_style().ligne() + "", "" + get_style().etiquette() + "", get_domId1(), "" + get_style().ligne() + "", "" + get_style().etiquette() + "", get_domId2(), "" + get_style().ligne() + "", get_domId3(), get_domId4(), "" + get_style().boutons() + "", get_domId5(), get_domId6());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenBundle) GWT.create(com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenBundle.class);
      // Setup section.

      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 10 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenCss_style style;
    private com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenCss_style get_style() {
      return style;
    }
    private com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();

      return style;
    }

    /**
     * Getter for f_DialogBox1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.DialogBox get_f_DialogBox1() {
      return build_f_DialogBox1();
    }
    private com.google.gwt.user.client.ui.DialogBox build_f_DialogBox1() {
      // Creation section.
      final com.google.gwt.user.client.ui.DialogBox f_DialogBox1 = new com.google.gwt.user.client.ui.DialogBox(false, true);
      // Setup section.
      f_DialogBox1.setWidget(get_f_HTMLPanel2());
      f_DialogBox1.setGlassEnabled(true);
      f_DialogBox1.setText("Ajouter un livre");

      return f_DialogBox1;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_style().form() + "");

      {
        // Attach section.
        UiBinderUtil.TempAttachment __attachRecord__ = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());

        get_domId0Element().get();
        get_domId1Element().get();
        get_domId2Element().get();
        get_domId3Element().get();
        get_domId4Element().get();
        get_domId5Element().get();
        get_domId6Element().get();

        // Detach section.
        __attachRecord__.detach();
      }
      f_HTMLPanel2.addAndReplaceElement(get_champTitre(), get_domId0Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_champAuteur(), get_domId1Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_champAnnee(), get_domId2Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_champDisponible(), get_domId3Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_messageErreur(), get_domId4Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_boutonAnnuler(), get_domId5Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_boutonEnregistrer(), get_domId6Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId0;
    }

    /**
     * Getter for champTitre called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.TextBox get_champTitre() {
      return build_champTitre();
    }
    private com.google.gwt.user.client.ui.TextBox build_champTitre() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox champTitre = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      champTitre.setName("titre");

      this.owner.champTitre = champTitre;

      return champTitre;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.

      return domId0Element;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId1;
    private java.lang.String get_domId1() {
      return domId1;
    }
    private java.lang.String build_domId1() {
      // Creation section.
      domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId1;
    }

    /**
     * Getter for champAuteur called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.TextBox get_champAuteur() {
      return build_champAuteur();
    }
    private com.google.gwt.user.client.ui.TextBox build_champAuteur() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox champAuteur = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      champAuteur.setName("auteur");

      this.owner.champAuteur = champAuteur;

      return champAuteur;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId1Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId1Element() {
      return domId1Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId1Element() {
      // Creation section.
      domId1Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId1());
      // Setup section.

      return domId1Element;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId2;
    private java.lang.String get_domId2() {
      return domId2;
    }
    private java.lang.String build_domId2() {
      // Creation section.
      domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId2;
    }

    /**
     * Getter for champAnnee called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.IntegerBox get_champAnnee() {
      return build_champAnnee();
    }
    private com.google.gwt.user.client.ui.IntegerBox build_champAnnee() {
      // Creation section.
      final com.google.gwt.user.client.ui.IntegerBox champAnnee = (com.google.gwt.user.client.ui.IntegerBox) GWT.create(com.google.gwt.user.client.ui.IntegerBox.class);
      // Setup section.
      champAnnee.setName("annee");

      this.owner.champAnnee = champAnnee;

      return champAnnee;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId2Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId2Element() {
      return domId2Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId2Element() {
      // Creation section.
      domId2Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId2());
      // Setup section.

      return domId2Element;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId3;
    private java.lang.String get_domId3() {
      return domId3;
    }
    private java.lang.String build_domId3() {
      // Creation section.
      domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId3;
    }

    /**
     * Getter for champDisponible called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.CheckBox get_champDisponible() {
      return build_champDisponible();
    }
    private com.google.gwt.user.client.ui.CheckBox build_champDisponible() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox champDisponible = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      champDisponible.setHTML(template_html1().asString());
      champDisponible.setName("disponible");

      this.owner.champDisponible = champDisponible;

      return champDisponible;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId3Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId3Element() {
      return domId3Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId3Element() {
      // Creation section.
      domId3Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId3());
      // Setup section.

      return domId3Element;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId4;
    private java.lang.String get_domId4() {
      return domId4;
    }
    private java.lang.String build_domId4() {
      // Creation section.
      domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId4;
    }

    /**
     * Getter for messageErreur called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_messageErreur() {
      return build_messageErreur();
    }
    private com.google.gwt.user.client.ui.Label build_messageErreur() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label messageErreur = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      messageErreur.setStyleName("" + get_style().erreur() + "");

      this.owner.messageErreur = messageErreur;

      return messageErreur;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId4Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId4Element() {
      return domId4Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId4Element() {
      // Creation section.
      domId4Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId4());
      // Setup section.

      return domId4Element;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId5;
    private java.lang.String get_domId5() {
      return domId5;
    }
    private java.lang.String build_domId5() {
      // Creation section.
      domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId5;
    }

    /**
     * Getter for boutonAnnuler called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_boutonAnnuler() {
      return build_boutonAnnuler();
    }
    private com.google.gwt.user.client.ui.Button build_boutonAnnuler() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button boutonAnnuler = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      boutonAnnuler.setHTML(template_html2().asString());
      boutonAnnuler.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

      this.owner.boutonAnnuler = boutonAnnuler;

      return boutonAnnuler;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId5Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId5Element() {
      return domId5Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId5Element() {
      // Creation section.
      domId5Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId5());
      // Setup section.

      return domId5Element;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId6;
    private java.lang.String get_domId6() {
      return domId6;
    }
    private java.lang.String build_domId6() {
      // Creation section.
      domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId6;
    }

    /**
     * Getter for boutonEnregistrer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_boutonEnregistrer() {
      return build_boutonEnregistrer();
    }
    private com.google.gwt.user.client.ui.Button build_boutonEnregistrer() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button boutonEnregistrer = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      boutonEnregistrer.setHTML(template_html3().asString());
      boutonEnregistrer.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

      this.owner.boutonEnregistrer = boutonEnregistrer;

      return boutonEnregistrer;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId6Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId6Element() {
      return domId6Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId6Element() {
      // Creation section.
      domId6Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId6());
      // Setup section.

      return domId6Element;
    }
  }
}

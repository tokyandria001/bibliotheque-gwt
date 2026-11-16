package com.toky.bibliotheque;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class LivreFormDialog_BinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenBundle {
  private static LivreFormDialog_BinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new LivreFormDialog_BinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenCss_style() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "style";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-form {\n  padding : " + ("12px")  + ";\n  min-width : " + ("320px")  + ";\n}\n.com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-ligne {\n  margin-bottom : " + ("8px")  + ";\n}\n.com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-etiquette {\n  display : " + ("inline-block")  + ";\n  width : " + ("90px")  + ";\n}\n.com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-erreur {\n  color : " + ("#c0392b")  + ";\n  margin : " + ("8px"+ " " +"0")  + ";\n  min-height : " + ("1em")  + ";\n}\n.com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-boutons {\n  text-align : " + ("left")  + ";\n  margin-top : " + ("12px")  + ";\n}\n")) : ((".com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-form {\n  padding : " + ("12px")  + ";\n  min-width : " + ("320px")  + ";\n}\n.com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-ligne {\n  margin-bottom : " + ("8px")  + ";\n}\n.com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-etiquette {\n  display : " + ("inline-block")  + ";\n  width : " + ("90px")  + ";\n}\n.com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-erreur {\n  color : " + ("#c0392b")  + ";\n  margin : " + ("8px"+ " " +"0")  + ";\n  min-height : " + ("1em")  + ";\n}\n.com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-boutons {\n  text-align : " + ("right")  + ";\n  margin-top : " + ("12px")  + ";\n}\n"));
      }
      public java.lang.String boutons() {
        return "com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-boutons";
      }
      public java.lang.String erreur() {
        return "com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-erreur";
      }
      public java.lang.String etiquette() {
        return "com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-etiquette";
      }
      public java.lang.String form() {
        return "com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-form";
      }
      public java.lang.String ligne() {
        return "com-toky-bibliotheque-LivreFormDialog_BinderImpl_GenCss_style-ligne";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'style': return this.@com.toky.bibliotheque.LivreFormDialog_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}

package com.toky.bibliotheque;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BibliothequeView_BinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.toky.bibliotheque.BibliothequeView_BinderImpl_GenBundle {
  private static BibliothequeView_BinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new BibliothequeView_BinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.toky.bibliotheque.BibliothequeView_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-page {\n  max-width : " + ("900px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  padding : " + ("24px")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n}\n.com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-titre {\n  color : " + ("#2c3e50")  + ";\n  margin-bottom : " + ("4px")  + ";\n  text-align : " + ("right")  + ";\n}\n.com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-sousTitre {\n  color : " + ("#7f8c8d")  + ";\n  margin-top : " + ("0")  + ";\n  margin-bottom : " + ("24px")  + ";\n}\n.com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-barre {\n  margin-bottom : ") + (("12px")  + ";\n}\n.com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-tableau {\n  width : " + ("100%")  + ";\n}\n")) : ((".com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-page {\n  max-width : " + ("900px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  padding : " + ("24px")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n}\n.com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-titre {\n  color : " + ("#2c3e50")  + ";\n  margin-bottom : " + ("4px")  + ";\n  text-align : " + ("left")  + ";\n}\n.com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-sousTitre {\n  color : " + ("#7f8c8d")  + ";\n  margin-top : " + ("0")  + ";\n  margin-bottom : " + ("24px")  + ";\n}\n.com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-barre {\n  margin-bottom : ") + (("12px")  + ";\n}\n.com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-tableau {\n  width : " + ("100%")  + ";\n}\n"));
      }
      public java.lang.String barre() {
        return "com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-barre";
      }
      public java.lang.String page() {
        return "com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-page";
      }
      public java.lang.String sousTitre() {
        return "com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-sousTitre";
      }
      public java.lang.String tableau() {
        return "com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-tableau";
      }
      public java.lang.String titre() {
        return "com-toky-bibliotheque-BibliothequeView_BinderImpl_GenCss_style-titre";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.toky.bibliotheque.BibliothequeView_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.toky.bibliotheque.BibliothequeView_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.toky.bibliotheque.BibliothequeView_BinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.toky.bibliotheque.BibliothequeView_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}

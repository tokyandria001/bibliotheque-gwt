package com.toky.bibliotheque;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Livre_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getAnnee(com.toky.bibliotheque.Livre instance) /*-{
    return instance.@com.toky.bibliotheque.Livre::annee;
  }-*/;
  
  private static native void setAnnee(com.toky.bibliotheque.Livre instance, int value) 
  /*-{
    instance.@com.toky.bibliotheque.Livre::annee = value;
  }-*/;
  
  private static native java.lang.String getAuteur(com.toky.bibliotheque.Livre instance) /*-{
    return instance.@com.toky.bibliotheque.Livre::auteur;
  }-*/;
  
  private static native void setAuteur(com.toky.bibliotheque.Livre instance, java.lang.String value) 
  /*-{
    instance.@com.toky.bibliotheque.Livre::auteur = value;
  }-*/;
  
  private static native boolean getDisponible(com.toky.bibliotheque.Livre instance) /*-{
    return instance.@com.toky.bibliotheque.Livre::disponible;
  }-*/;
  
  private static native void setDisponible(com.toky.bibliotheque.Livre instance, boolean value) 
  /*-{
    instance.@com.toky.bibliotheque.Livre::disponible = value;
  }-*/;
  
  private static native java.lang.Long getId(com.toky.bibliotheque.Livre instance) /*-{
    return instance.@com.toky.bibliotheque.Livre::id;
  }-*/;
  
  private static native void setId(com.toky.bibliotheque.Livre instance, java.lang.Long value) 
  /*-{
    instance.@com.toky.bibliotheque.Livre::id = value;
  }-*/;
  
  private static native java.lang.String getTitre(com.toky.bibliotheque.Livre instance) /*-{
    return instance.@com.toky.bibliotheque.Livre::titre;
  }-*/;
  
  private static native void setTitre(com.toky.bibliotheque.Livre instance, java.lang.String value) 
  /*-{
    instance.@com.toky.bibliotheque.Livre::titre = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.toky.bibliotheque.Livre instance) throws SerializationException {
    setAnnee(instance, streamReader.readInt());
    setAuteur(instance, streamReader.readString());
    setDisponible(instance, streamReader.readBoolean());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setTitre(instance, streamReader.readString());
    
  }
  
  public static com.toky.bibliotheque.Livre instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.toky.bibliotheque.Livre();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.toky.bibliotheque.Livre instance) throws SerializationException {
    streamWriter.writeInt(getAnnee(instance));
    streamWriter.writeString(getAuteur(instance));
    streamWriter.writeBoolean(getDisponible(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getTitre(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.toky.bibliotheque.Livre_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.toky.bibliotheque.Livre_FieldSerializer.deserialize(reader, (com.toky.bibliotheque.Livre)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.toky.bibliotheque.Livre_FieldSerializer.serialize(writer, (com.toky.bibliotheque.Livre)object);
  }
  
}

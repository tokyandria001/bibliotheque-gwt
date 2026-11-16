package com.toky.bibliotheque;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GreetingResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getGreeting(com.toky.bibliotheque.GreetingResponse instance) /*-{
    return instance.@com.toky.bibliotheque.GreetingResponse::greeting;
  }-*/;
  
  private static native void setGreeting(com.toky.bibliotheque.GreetingResponse instance, java.lang.String value) 
  /*-{
    instance.@com.toky.bibliotheque.GreetingResponse::greeting = value;
  }-*/;
  
  private static native java.lang.String getServerInfo(com.toky.bibliotheque.GreetingResponse instance) /*-{
    return instance.@com.toky.bibliotheque.GreetingResponse::serverInfo;
  }-*/;
  
  private static native void setServerInfo(com.toky.bibliotheque.GreetingResponse instance, java.lang.String value) 
  /*-{
    instance.@com.toky.bibliotheque.GreetingResponse::serverInfo = value;
  }-*/;
  
  private static native java.lang.String getUserAgent(com.toky.bibliotheque.GreetingResponse instance) /*-{
    return instance.@com.toky.bibliotheque.GreetingResponse::userAgent;
  }-*/;
  
  private static native void setUserAgent(com.toky.bibliotheque.GreetingResponse instance, java.lang.String value) 
  /*-{
    instance.@com.toky.bibliotheque.GreetingResponse::userAgent = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.toky.bibliotheque.GreetingResponse instance) throws SerializationException {
    setGreeting(instance, streamReader.readString());
    setServerInfo(instance, streamReader.readString());
    setUserAgent(instance, streamReader.readString());
    
  }
  
  public static com.toky.bibliotheque.GreetingResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.toky.bibliotheque.GreetingResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.toky.bibliotheque.GreetingResponse instance) throws SerializationException {
    streamWriter.writeString(getGreeting(instance));
    streamWriter.writeString(getServerInfo(instance));
    streamWriter.writeString(getUserAgent(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.toky.bibliotheque.GreetingResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.toky.bibliotheque.GreetingResponse_FieldSerializer.deserialize(reader, (com.toky.bibliotheque.GreetingResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.toky.bibliotheque.GreetingResponse_FieldSerializer.serialize(writer, (com.toky.bibliotheque.GreetingResponse)object);
  }
  
}

package ChatInterface;

/**
* ChatInterface/UnknownIDHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ChatInterface.idl
* Friday, December 1, 2017 12:01:21 AM BRT
*/

public final class UnknownIDHolder implements org.omg.CORBA.portable.Streamable
{
  public ChatInterface.UnknownID value = null;

  public UnknownIDHolder ()
  {
  }

  public UnknownIDHolder (ChatInterface.UnknownID initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ChatInterface.UnknownIDHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ChatInterface.UnknownIDHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ChatInterface.UnknownIDHelper.type ();
  }

}

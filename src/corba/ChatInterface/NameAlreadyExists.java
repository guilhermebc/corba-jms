package ChatInterface;


/**
* ChatInterface/NameAlreadyExists.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ChatInterface.idl
* Friday, December 1, 2017 12:01:21 AM BRT
*/

public final class NameAlreadyExists extends org.omg.CORBA.UserException
{

  public NameAlreadyExists ()
  {
    super(NameAlreadyExistsHelper.id());
  } // ctor


  public NameAlreadyExists (String $reason)
  {
    super(NameAlreadyExistsHelper.id() + "  " + $reason);
  } // ctor

} // class NameAlreadyExists

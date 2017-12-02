package ChatInterface;


/**
* ChatInterface/_ChatServerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ChatInterface.idl
* Friday, December 1, 2017 12:01:21 AM BRT
*/

public class _ChatServerStub extends org.omg.CORBA.portable.ObjectImpl implements ChatInterface.ChatServer
{

  public String subscribe (String nick, ChatInterface.ChatClient c) throws ChatInterface.NameAlreadyExists
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("subscribe", true);
                $out.write_string (nick);
                ChatInterface.ChatClientHelper.write ($out, c);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:ChatInterface/NameAlreadyExists:1.0"))
                    throw ChatInterface.NameAlreadyExistsHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return subscribe (nick, c        );
            } finally {
                _releaseReply ($in);
            }
  } // subscribe

  public void unsubscribe (String id) throws ChatInterface.UnknownID
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("unsubscribe", true);
                $out.write_string (id);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:ChatInterface/UnknownID:1.0"))
                    throw ChatInterface.UnknownIDHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                unsubscribe (id        );
            } finally {
                _releaseReply ($in);
            }
  } // unsubscribe

  public void send (String id, String text) throws ChatInterface.UnknownID
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("send", true);
                $out.write_string (id);
                $out.write_string (text);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:ChatInterface/UnknownID:1.0"))
                    throw ChatInterface.UnknownIDHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                send (id, text        );
            } finally {
                _releaseReply ($in);
            }
  } // send

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ChatInterface/ChatServer:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ChatServerStub

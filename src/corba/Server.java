package corba;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

public class Server {

    public static void main(String args[]){
        try {
            // initializing ORB
            ORB orb = ORB.init(args, null);

            // getting reference to POA
            org.omg.CORBA.Object objPoa = orb.resolve_initial_references("RootPOA");
            POA rootPOA = POAHelper.narrow(objPoa);

            // getting NameService
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
            NamingContext naming = NamingContextHelper.narrow(obj);

            // creating servant
//            ChatServerImpl chat = new ChatServerImpl();
            corba.ChatServerImpl chat = new ChatServerImpl();

            // connecting servant to ORB
            org.omg.CORBA.Object objRef = rootPOA.servant_to_reference(chat);

            // binding servant reference to NameService
            NameComponent[] name = {new NameComponent("Chat","Exemplo")};
            naming.rebind(name,objRef);
            rootPOA.the_POAManager().activate();

            System.out.println("Servidor CORBA criado!...");

            // starting orb
            orb.run();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

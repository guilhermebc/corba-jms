import org.omg.CORBA.*;
import org.omg.CosNaming.*; 
import org.omg.PortableServer.*;

public class Server{
	public void main(String args[]){
		try{
			ORB orb = ORB.init(args,null); 	
			org.omg.CORBA.Object objPoa = orb.resolve_initial_references("RootPOA");
			POA rootPOA = POAHelper.narrow(objPoa);		

			org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
			NamingContext naming = NamingContextHelper.narrow(obj);
			ServerImpl chat = new ServerImpl();
			org.omg.CORBA.Object objRef = rootPOA.servant_to_reference(chat);
			NameComponent[] name = {new NameComponent("Chat", "")};
			naming.rebind(name,objRef);

			rootPOA.the_POAManager().activate();

			System.out.println("Servidor Pronto ...");

			orb.run();

		   }catch (Exception ex){
				System.out.println("Erro");
				ex.printStackTrace();
			}
	}
}
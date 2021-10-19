package cau_1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements Server {
	FileOutputStream fout = null;
	Server server;
	private static final long serialVersionUID = 1L;
	Registry rmiRegistry;

        public ServerImpl() throws RemoteException {
            super();
        }

        public void start() throws Exception {
            rmiRegistry = LocateRegistry.createRegistry(1099);
            Server server = new ServerImpl();
            rmiRegistry.bind("server", server);
            System.out.println("Server started. Waiting for file!");            
        }

        public void stop() throws Exception {
            rmiRegistry.unbind("server");
            unexportObject(this, true);
            unexportObject(rmiRegistry, true);
            System.out.println("Server stopped");
        }

		@Override
		public String daoNguocChuoi(String content) throws RemoteException {
			  String str= content, nstr="";
		        char ch;
		       
		      for (int i=0; i<str.length(); i++)
		      {
		        ch= str.charAt(i); //extracts each character
		        nstr= ch+nstr; //adds each character in front of the existing string
		      }
		      System.out.println("Reversed word is: "+ nstr);
			return nstr;
		}
        
   	       
}
    	
        
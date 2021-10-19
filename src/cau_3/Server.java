package cau_3;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public Registry rmiRegistry;
	
	public Server() throws RemoteException, MalformedURLException, AlreadyBoundException {
		rmiRegistry = LocateRegistry.createRegistry(1099);
		CSDLLogin c = new CSDLLoginIm();
		Naming.bind("rmi://localhost/enter", c);
		System.out.println("Máy chủ đã sẵn sàng phục vụ!");   
	}
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		new Server();
	}
}

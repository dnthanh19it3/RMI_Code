package cau4;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import cau_3.CSDLLogin;
import cau_3.CSDLLoginIm;

public class Server {
	public Registry rmiRegistry;
	
	public Server() throws RemoteException, MalformedURLException, AlreadyBoundException {
		rmiRegistry = LocateRegistry.createRegistry(1099);
		CSDLinforIm a = new CSDLinforIm();
		Naming.bind("rmi://localhost/infor", a);
		System.out.println("Máy chủ đã sẵn sàng phục vụ!");   
	}
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		Server server = new Server();
	}
}
package cau_3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CSDLLogin extends Remote{
		
 public	boolean Check(String a ,String b) throws RemoteException;

}

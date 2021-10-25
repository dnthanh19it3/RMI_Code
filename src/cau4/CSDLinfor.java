package cau4;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CSDLinfor extends Remote {
	
 public String getInfor(String a) throws RemoteException;
 public boolean SaveInfor(String a, String b,String c,String d) throws RemoteException;
}
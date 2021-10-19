package cau_3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner input = new Scanner(System.in);
		  System.out.println("Nhap user ");
		  String a = input.nextLine();
		  System.out.println("Nhap pass ");
		  String b = input.nextLine();
		  try {
			CSDLLogin check = (CSDLLogin) Naming.lookup("rmi://localhost/enter");
			if(check.Check(a, b))
			{
				System.out.println("Thành công");
				
			}
			else
			{
				System.out.println("Thất bại");
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}

}

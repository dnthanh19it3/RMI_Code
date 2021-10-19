package cau_2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class FactorialClient {
	public static void main(String[] args)
	{

		try {
			Factorial c = (Factorial) Naming.lookup("rmi://localhost/FactorialService");
			 Scanner scanner = new Scanner(System.in);
			 System.out.println("Giai thừa cần tính: ");
		     int inputNum = Integer.parseInt(scanner.nextLine());
		     System.out.println("Kết quả là: " + c.fact(inputNum));
		}
		catch (MalformedURLException murle) {
			System.out.println("\nMalformedURLException: "+ murle);
		}

		catch (RemoteException re) {
			System.out.println("\nRemoteException: "+ re);
		}

		catch (NotBoundException nbe) {
			System.out.println("\nNotBoundException: "+ nbe);
		}

		catch (java.lang.ArithmeticException ae) {
			System.out.println("\nArithmeticException: " + ae);
		}
	}
}
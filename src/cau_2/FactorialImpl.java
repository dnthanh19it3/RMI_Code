package cau_2;

import java.math.BigInteger;

public class FactorialImpl
	extends java.rmi.server.UnicastRemoteObject
	implements Factorial {

	// Khai báo Constructor
	public FactorialImpl()
		throws java.rmi.RemoteException
	{
		super();
	}

	public long fact(int num)
		throws java.rmi.RemoteException
	{
		System.out.println(num);
		long fact = 1;
	    for (int i = 2; i <= num; i++) {
	        fact = fact * i;
	    }
		System.out.println("Kết quả là: " + fact);
		return fact;
	}
}
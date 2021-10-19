package cau_2;

import java.math.BigInteger;

public interface Factorial
	extends java.rmi.Remote {
	public long fact(int num)
		throws java.rmi.RemoteException;
}
package cau_2;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FactorialServer {
	Registry rmiRegistry;
	public FactorialServer()
	{
		try {
			rmiRegistry = LocateRegistry.createRegistry(1099);
			Factorial c = new FactorialImpl();
			Naming.bind("rmi://localhost/FactorialService", c);
			System.out.println("Server Started");
		}
		catch (Exception e) {
			System.err.println("Lỗi khởi tạo Server, chi tiết lỗi: " + e);
		}
	}

	public static void main(String[] args)
	{
		new FactorialServer();
	}
}
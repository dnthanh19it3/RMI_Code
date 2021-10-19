package cau_1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.rmi.Naming;
import java.util.Scanner;

public class ClientMain {
	 public static void main(String[] args) throws Exception {
	        String url = "rmi://localhost/server";
	        Server server = (Server) Naming.lookup(url);
	        System.out.println("Chuỗi bạn muốn đảo ngược: ");
	        Scanner scanner = new Scanner(System.in);
	        String chuoi = scanner.nextLine();
	        String chuoiDaoNguoc = server.daoNguocChuoi(chuoi);
	        System.out.println("Chuỗi đảo ngược là: " + chuoiDaoNguoc);
	 } 
}

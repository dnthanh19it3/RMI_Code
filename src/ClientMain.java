import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.rmi.Naming;

public class ClientMain {
	 public static void main(String[] args) throws Exception {
	        
	        String url = "rmi://localhost/server";
	        Server server = (Server) Naming.lookup(url);
	        server.waitFile();
	        
	        
//	        server.sendFileName("server_temp/temp.xml");
//	        FileInputStream fin = new FileInputStream("server_temp/temp.txt");	        
//			byte[] data = new byte[8192];
//			int byteReads;
//			try {
//				byteReads = fin.read(data);
//				while(byteReads != -1) {
//					server.sendData(data, 0, byteReads);
//					byteReads = fin.read(data);
//				}
//				//	đóng file khi đã hoàn thành
//				server.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
	    }
	 
	 
	 
	 
	 
}

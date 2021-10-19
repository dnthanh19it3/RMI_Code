import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements Server {
	FileOutputStream fout = null;
	Server server;
	private static final long serialVersionUID = 1L;
	Registry rmiRegistry;

        public ServerImpl() throws RemoteException {
            super();
        }

        public void start() throws Exception {
            rmiRegistry = LocateRegistry.createRegistry(1099);
            server = new ServerImpl();
            server.setFile(server);
            rmiRegistry.bind("server", server);
            System.out.println("Server started. Waiting for file!");            
        }

        public void stop() throws Exception {
            rmiRegistry.unbind("server");
            unexportObject(this, true);
            unexportObject(rmiRegistry, true);
            System.out.println("Server stopped");
        }
        
        public String sayHello(String content) {
        	System.out.println("Noi dung la: " + content); // server thuc thi
            return content;
        }
    	
        
        //Close connect
    	public void close() throws RemoteException {
    		if(fout != null) {
    			try {
    				fout.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	//Send data
    	public void sendData(byte[] data, int offset, int length) throws RemoteException {
    		System.out.println("Chạy send data");
    		if(fout != null) {
    			try {
    				fout.write(data, offset, length);
    				fout.flush();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	//Send file name
    	public void sendFileName(String fileName) throws RemoteException {
    		System.out.println("Chạy send file name");
    		if(fout == null) {
    			try {
    				fout = new FileOutputStream(fileName);
    			} catch (FileNotFoundException e) {
    				e.printStackTrace();
    			}
    		}
    	}

		@Override
		public void waitFile() throws RemoteException {
			if(fout != null) {
				System.out.println("File OKE");
			}
		}
		
		@Override
		public void setFile(Server server) throws RemoteException, FileNotFoundException {
			if(server == null) {
            	System.out.println("Null me roi");
            }
			FileInputStream fin = new FileInputStream("server_temp/test1.xml");
			byte[] data = new byte[8192];
			int byteReads;
			try {
				byteReads = fin.read(data);
				while(byteReads != -1) {
					server.sendData(data, 0, byteReads);
					byteReads = fin.read(data);
				}
				System.out.println("Gửi file từ server thành công!");
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	
        
    }
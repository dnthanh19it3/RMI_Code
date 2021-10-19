import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
        public String sayHello(String content) throws RemoteException;
        public void close() throws RemoteException;
    	public void sendData(byte[] data, int offset, int length) throws RemoteException;
    	public void sendFileName(String fileName) throws RemoteException;
    	public void waitFile() throws RemoteException;
    	public void setFile(Server server) throws RemoteException, FileNotFoundException;
    }
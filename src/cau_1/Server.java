package cau_1;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
        public String daoNguocChuoi(String content) throws RemoteException;
    }
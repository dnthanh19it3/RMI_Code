package cau4;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CSDLinforIm extends java.rmi.server.UnicastRemoteObject implements CSDLinfor {

	Connection con;
	public CSDLinforIm() throws java.rmi.RemoteException {
		// TODO Auto-generated constructor stub
		try {
			con = DriverManager.getConnection("jdbc:sqlite:lib//cau4.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String getInfor(String a) throws RemoteException {
		// TODO Auto-generated method stub
		ResultSet kq=null;
        Statement stCmd;
		try {
			stCmd = con.createStatement();
		    String sqlQuery = "select * from LocationInfor where Location LIKE '%"+a+"%' ";
	        kq = stCmd.executeQuery(sqlQuery);
	        while(kq.next()) {
	        	
	        	return (kq.getString("Location")+":"+kq.getString("Address")+":"+kq.getString("Phone")+":"+kq.getString("Note")+" ");
	        
		} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Khong tim thay";
	}

	@Override
	public boolean SaveInfor(String a, String b, String c, String d)
			throws RemoteException {
		// TODO Auto-generated method stub
		ResultSet kq=null;
        Statement stCmd;
		
			try {
				stCmd = con.createStatement();
				String insert="insert into LocationInfor (Location, Address, Phone, Note) values('"+a+"','"+b+"','"+c+"','"+d+"')";
				stCmd.execute(insert);
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

	}
	

}

package cau_3;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CSDLLoginIm extends java.rmi.server.UnicastRemoteObject implements CSDLLogin
{

	Connection con;
	public CSDLLoginIm() throws java.rmi.RemoteException
	{
	 String Url="jdbc:sqlite:lib//test.db";
	try {
		con = DriverManager.getConnection(Url);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	public boolean Check(String a, String b) throws RemoteException {
		// TODO Auto-generated method stub
		    ResultSet kq=null;
	        Statement stCmd;
			try {
				stCmd = con.createStatement();
			    String sqlQuery = "select * from login";
		        kq = stCmd.executeQuery(sqlQuery);
		        while(kq.next()) {
		        	String ms=kq.getString("name");
		        	String mk=kq.getString("pass");
		        	if(ms.equals(a)&&mk.equals(b)) 
		        	{
		        		return true;
		        		
		        	}
			} 
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	        
	     
		return false;
	}

}

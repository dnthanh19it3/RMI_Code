package cau4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Client extends JFrame implements ActionListener {

	/**
	 * @param args
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	private CSDLinfor a;
	private JButton btfind = new JButton("find");
	private JButton btSave = new JButton("Save");
	private JTextField tx =new JTextField(30);
	private JTextArea ta = new JTextArea(10,10);
	public Client() throws MalformedURLException, RemoteException, NotBoundException
	{
	    a = (CSDLinfor) Naming.lookup("rmi://localhost/infor");
	    setSize(500, 200);
	    
	    JPanel p0 = new JPanel();
	    p0.setLayout(new FlowLayout());
	    p0.add(tx);
	    p0.add(btfind);
	    p0.add(btSave);
	    add(ta,BorderLayout.SOUTH);
	    add(p0,BorderLayout.NORTH);
	    
	    //
	    btfind.addActionListener(this);
	    btSave.addActionListener(this);
		this.pack();
		
		
	}
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		
	  Client a = new Client();
	  a.show();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btfind)
		{
			String infor =tx.getText();
			try {
				
				ta.setText(a.getInfor(infor));
				
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==btSave)
		{
			String infor = tx.getText();
			String location, address, phone, note;
			String[] split = infor.split(",");
			
			if(!infor.contains(",")) {
				JOptionPane.showMessageDialog(this, "D?? li???u ?????u v??o kh??ng ????ng ?????nh d???ng. Vui l??ng nh???p l??n l?????t c??c tr?????ng theo c?? ph??p sau: Location, Address, Phone, Note. Tr?????ng kh??ng c?? vui l??ng b??? tr???ng!");				
			} else {
				try {
					if(a.SaveInfor(split[0], split[1], split[2], split[3])) {
						JOptionPane.showMessageDialog(this, "Nh???p ho??n th??nh!");
					} else {
						JOptionPane.showMessageDialog(this, "C?? l???i x???y ra! Vui l??ng ki???m tra l???i!");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}

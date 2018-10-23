package mlcp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement ;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.*;
public class ParkingRelease extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
Choice ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8,ch9,ch10,ch11,ch12,ch13,ch14,ch15,ch16,ch17,ch18,ch19,ch20,ch21,ch22;
String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a13,a11,a12="avail",a14,a15,a16,a18,a19,a20,a21,a22;
JButton b1,b2,b3,b4;
Checkbox c1,c2,c3;
ImageIcon ic;
Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;
Random rd;
Date dt;

JFileChooser chooser=new JFileChooser();

public ParkingRelease( )
{
rd=new Random();
dt=new Date();
l1=new JLabel("PARKING ID");
l2=new JLabel("OWNER NAME");
l3=new JLabel("RC NUMBER");
l4=new JLabel("ADDRESS");
l5=new JLabel("CONTACT");
l6=new JLabel("release TIME");
l7=new JLabel(" MODEL ");
l8=new JLabel("LEVEL NO");
l9=new JLabel("TACK NO");
l10=new JLabel(" ");
l11=new JLabel("as");
l12=new JLabel("date");
t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
t5=new JTextField();
t6=new JTextField();
t7=new JTextField();
t8=new JTextField();
t9=new JTextField();

t10=new JTextField();
ch7=new Choice();

b1= new JButton("SAVE");

b2= new JButton("CLOSE");
b3=new JButton("SEARCH");
ic=new ImageIcon( "regi.png");
l11=new JLabel("",ic,JLabel.CENTER);

}
public void SetUpParkingRelease()
{

frm=new Frame("title"); 
frm.setSize(2000,1500);       
frm.setLayout(null);

l1.setBounds(50,220,70,25);
l2.setBounds(50,260,70,25);
l3.setBounds(50,300,70,25);
l4.setBounds(50,340,70,25);
l5.setBounds(50,380,70,25);
l6.setBounds(50,420,70,25);
l7.setBounds(50,460,70,25);
l8.setBounds(50,500,70,25);
l9.setBounds(50,540,70,25);
l10.setBounds(50,580,100,25);
l11.setBounds(50,50,800,150);
l12.setBounds(50,620,100,25);

t1.setBounds(150,220,150,25);
t2.setBounds(150,260,150,25);
t3.setBounds(150,300,150,25);
t4.setBounds(150,340,150,25);
t5.setBounds(150,380,150,25);
t6.setBounds(150,420,150,25);

t7.setBounds(150,460,150,25);
//ch7.addItemListener(this);
t8.setBounds(150,500,150,25);
t9.setBounds(150,540,150,25);
t10.setBounds(150,620,150,25);
b1.setBounds(50,670,150,25);
b2.setBounds(210,670,150,25);
b3.setBounds(390,660,150,25);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
frm.add(l1);
frm.add(l2);
frm.add(l3);
frm.add(l4);
frm.add(l5);
frm.add(l6);
frm.add(l7);
frm.add(l8);
frm.add(l9);
frm.add(l10);
frm.add(l11);
frm.add(l12);
frm.add(t1);
frm.add(t2);
frm.add(t3);
frm.add(t4);
frm.add(t5);
frm.add(t6);
frm.add(t7);
frm.add(t8);
frm.add(t9);
frm.add(t10);
frm.add(b1);
frm.add(b2);
frm.add(b3);
connect();
frm.setVisible(true);
}


public void connect()
{
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	con=DriverManager.getConnection("jdbc:odbc:LMS");//protocol:subprotocol
	}
	catch(Exception ex)
	{	
	System.out.println("Connection Error = "+ex);
	}
}

public void  SearchCar()
{
  a1=t1.getText();
	try
	{
		stat=con.createStatement();
		rst=stat.executeQuery("select * from Parking where parking id= '"+a1+"'");
		if(rst.next())
		{

	                              		t2.setText(rst.getString(2));
				t3.setText(rst.getString(3));
				t4.setText(rst.getString(4));
				t5.setText(rst.getString(5));
				t6.setText(rst.getString(6));
				t7.setText(rst.getString(7));
				t8.setText(rst.getString(8));
				t9.setText(rst.getString(9));
				t10.setText(rst.getString(9));
				t11.setText(rst.getString(9));
		}
	}
	catch(Exception ex)
	{
		System.out.println("TrackNumber Error=+ex");
	}
}



public void UpdateData()
{
a13=t8.getText();
a14=t9.getText();
try
{
pst=con.prepareStatement(" update   trackinfo set status='"+a12+"' where ln='"+a13+"' and tn='"+a14+"'");
pst.executeUpdate();
}
catch(Exception ex)
{
System.out.println("Ërror in insert"+ex);
}
}




public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b3)
{
SearchCar();
}
if(ae.getSource()==b1)
{
UpdateData();
}
}
}
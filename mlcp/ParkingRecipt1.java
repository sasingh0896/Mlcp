package mlcp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ParkingRecipt1 extends  Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
JButton b1,b2,b3;
String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a14,a15,a16,a20,a43,a36;


Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;

public ParkingRecipt1()
{	
l1=new JLabel("Parking id");
l2=new JLabel("owner name");
l3=new JLabel("RC number");
l4=new JLabel("Address");
l5=new JLabel("Contact no");
l6=new JLabel("parking time");
l7=new JLabel("parking Date");
l8=new JLabel("model");
l9=new JLabel("level no");
l10=new JLabel("track");
l11=new JLabel("status");
l12=new JLabel("");
l13=new JLabel("");


b1=new JButton("Print");
b1.addActionListener(this);

b2=new JButton("Close");
b2.addActionListener(this);
b2.setToolTipText("Click to close and do exit");
b3=new JButton("ShowDetail");
b3.addActionListener(this);
b3.setToolTipText("show all detail of parking");

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
t11=new JTextField();
//t12=new JTextField();
//t13=new JTextField();


}
public void setUpParkingRecipt1(String a43)
{

a36=a43;
frm=new Frame("Parking Recipt");
frm.setLayout(null);
frm.setSize(2000,1500);
//frm.setLocation(200,75);

l1.setBounds(20,140,150,25);
frm.add(l1);
t1.setBounds(170,140,150,25);
frm.add(t1);

l2.setBounds(20,170,150,25);
frm.add(l2);
t2.setBounds(170,170,150,25);
frm.add(t2);

l3.setBounds(20,200,150,25);
frm.add(l3);
t3.setBounds(170,200,150,25);
frm.add(t3);

l4.setBounds(20,230,150,25);
frm.add(l4);
t4.setBounds(170,230,150,25);
frm.add(t4);

l5.setBounds(20,260,150,25);
frm.add(l5);
t5.setBounds(170,260,150,25);
frm.add(t5);

l6.setBounds(20,290,150,25);
frm.add(l6);
t6.setBounds(170,290,150,25);
frm.add(t6);

l7.setBounds(20,320,150,25);
frm.add(l7);
t7.setBounds(170,320,150,25);
frm.add(t7);

l8.setBounds(20,350,150,25);
frm.add(l8);
t8.setBounds(170,350,150,25);
frm.add(t8);

l9.setBounds(20,380,150,25);
frm.add(l9);
t9.setBounds(170,380,150,25);
frm.add(t9);

l10.setBounds(20,410,150,25);
frm.add(l10);
t10.setBounds(170,410,150,25);
frm.add(t10);

l11.setBounds(250,100,150,25);
frm.add(l11);
t11.setBounds(350,1000,150,25);
frm.add(t11);

/*l12.setBounds(250,150,150,25);
frm.add(l12);
t12.setBounds(350,150,150,25);
frm.add(t12);*/


/*l14.setBounds(500,140,150,25);
frm.add(l14);
t14.setBounds(600,140,150,25);
frm.add(t14);

l15.setBounds(500,170,150,25);
frm.add(l15);
t15.setBounds(600,170,150,25);
frm.add(t15);

l16.setBounds(500,200,150,25);
frm.add(l16);
t16.setBounds(600,200,150,25);
frm.add(t16);
*/

b1.setBounds(30,500,100,25);
frm.add(b1);
b2.setBounds(150,500,100,25);
frm.add(b2);
b3.setBounds(270,500,100,25);
frm.add(b3);

t1.setText(a36);

connect();
frm.setVisible(true);
}
public void getData()
{
	try
	{
	a1=t1.getText();
	a2=t2.getText();
	a3=t3.getText();
	a4=t4.getText();
	a5=t5.getText();
	a6=t6.getText();
	a7=t7.getText();
	a8=t8.getText();
	a9=t9.getText();
	a10=t10.getText();
	a11=t11.getText();
		
	}
	catch(Exception ex)
	{
		System.out.println("getData equals="+ex);
	}
}
public void connect()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:LMS");
}
catch(Exception ex)
{
System.out.println("connection Error="+ex);
}
}
public void searchData()
{ 
  a1=t1.getText();
	try
	{
		
		a2=t2.getText();
		stat=con.createStatement();
		rst=stat.executeQuery("select * from Parking where parkingid='"+a1+"'");
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
		  t10.setText(rst.getString(10));
		  t11.setText(rst.getString(11));
		  }
       
	} 
	catch(Exception ex)
	{
		System.out.println("getParkingRecord Error=+ex");
	}
}
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b2)
	{
		System.exit(0);
	}
	if(ae.getSource()==b1)
	{
		
	}
	if(ae.getSource()==b3)
	{
	
		getData();
		connect();
		searchData();	
	}
}
}









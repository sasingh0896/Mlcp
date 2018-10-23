package mlcp;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ForgotPassword extends Frame implements ActionListener
{
JButton b1,b2,b3;
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JTextField t1,t2;
ImageIcon ic;
String a1,a2;
Frame frm;


Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;

public ForgotPassword()
{

b1=new JButton("OK");
b1.setOpaque(false);
b1.setContentAreaFilled(false);
//b1.setBorderPainted(false); only ok
b1.addActionListener(this);
b1.setToolTipText("Click to search your USERID");

b2=new JButton("Retrive");
b2.setOpaque(false);
b2.setContentAreaFilled(false);
b2.addActionListener(this);
b2.setToolTipText("Click to retrive your Password");

b3=new JButton("Exit");
b3.setOpaque(false);
b3.setContentAreaFilled(false);
b3.addActionListener(this);
b3.setToolTipText("click to exit");

l1=new JLabel("Enter User ID");
l1.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l2=new JLabel("Your SQ is");
l2.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l3=new JLabel("Enter Answer");
l3.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l4=new JLabel("Your Password");
l4.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l5=new JLabel("");
l5.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l6=new JLabel("");
l6.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l7=new JLabel("");
l7.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));

t1=new JTextField();
t1.setOpaque(false);
t2=new JTextField();
t2.setOpaque(false);
frm=new Frame("Forgot Password");
}
public void setUpForgotPassword()
{
frm.setLayout(null);
frm.setSize(650,400);
frm.setLocation(300,200);
b1.setBounds(480,100,100,25);
frm.add(b1);
b2.setBounds(480,180,100,25);
frm.add(b2);
b3.setBounds(480,300,100,25);
frm.add(b3);

l1.setBounds(100,100,150,25);
frm.add(l1);
l2.setBounds(100,140,150,25);
frm.add(l2);
l3.setBounds(100,180,150,25);
frm.add(l3);
l4.setBounds(100,220,150,25);
frm.add(l4);
l5.setBounds(300,140,300,25);
frm.add(l5);
l6.setBounds(300,220,300,25);
frm.add(l6);
l7.setBounds(100,50,300,25);
frm.add(l7);

t1.setBounds(300,100,150,25);
frm.add(t1);
t2.setBounds(300,180,150,25);
frm.add(t2);

connect();
frm.setVisible(true);
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
	try
	{
		a1=t1.getText();
	    a2=t2.getText();
		stat=con.createStatement();
		rst=stat.executeQuery("select * from createAccount where userid='"+a1+"'");// and secQues='"+a2+"'");
		if(rst.next())
		{   
	      l5.setText(rst.getString(4));
		}
       
	} 
	catch(Exception ex)
	{
		System.out.println("getBookRecord Error=+ex");
	}
}
public void searchData1()
{
	try
	{
		a1=t1.getText();
	    a2=t2.getText();
		stat=con.createStatement();
		rst=stat.executeQuery("select * from createAccount where answer='"+a2+"'");// and secQues='"+a2+"'");
		if(rst.next())
		{   
	      l6.setText(rst.getString(2));
		}
       
	} 
	catch(Exception ex)
	{
		System.out.println("getBookRecord Error=+ex");
	}
}
public void actionPerformed(ActionEvent ae)
{
	
	if(ae.getSource()==b1)
	{
	    connect();
		searchData();	
	}
	else if(ae.getSource()==b2)
	{
		connect();
		searchData1();
	}
	else if(ae.getSource()==b3)
	{
		System.exit(0);
	}
}
}
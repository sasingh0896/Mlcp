package mlcp;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class LogIn extends Frame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField t1;
JPasswordField t2;
JButton b1,b2,b3;
String a1,a2;
ImageIcon ic,ic1,ic2;
Frame frm;

Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;

public LogIn()
{



ic1=new ImageIcon("key.png");	
ic=new ImageIcon("login2.png");	
l6=new JLabel("",ic,JLabel.CENTER);
l7=new JLabel("",ic,JLabel.LEFT);
ic2=new ImageIcon("editprofile.png");	
l8=new JLabel("",ic,JLabel.LEFT);

b1=new JButton("Login");
b1.setToolTipText("Please clickit to LogIn");
b2=new JButton("Exit");
b2.setToolTipText("Click to close and do exit");
b3=new JButton("Forgot password");
b3.setToolTipText("to recover the password");

l2=new JLabel("User ID");
l3=new JLabel("Password");
l4=new JLabel("");
l6=new JLabel("");

t1=new JTextField();
t2=new JPasswordField();

frm=new Frame("Log In");
}
public void setUpLogIn()
{
frm.setLayout(null);
frm.setSize(340,350);//400,390
frm.setLocation(400,200);

//l1.setBounds(230,100,600,50);
//frm.add(l1);

l2.setBounds(80,180,300,25);
frm.add(l2);

l3.setBounds(80,220,300,25);
frm.add(l3);

l4.setBounds(80,250,300,25);
frm.add(l4);

t1.setBounds(170,180,150,25);
frm.add(t1);

t2.setBounds(170,220,150,25);
frm.add(t2);

//l6.setBounds(0,0,600,600);
//frm.add(l6);

//l7.setBounds(0,0,100,100);
//frm.add(l7);

b1.setBounds(100,270,85,25);
b1.addActionListener(this);
frm.add(b1);

b2.setBounds(200,270,85,25);
b2.addActionListener(this);
frm.add(b2);

b3.setBounds(120,300,150,25);
b3.addActionListener(this);
frm.add(b3);

l8.setBounds(180,60,350,90);
l8.setIcon(ic2);
frm.add(l8);

l7.setBounds(50,50,100,100);
l7.setIcon(ic1);
frm.add(l7);

l6.setBounds(0,0,600,600);
l6.setIcon(ic);
frm.add(l6);




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
		rst=stat.executeQuery("select * from CreateAccountmlcp where userid='"+a1+"' and password='"+a2+"'");
		if(rst.next())
		{   //frm.setVisible(false);
			//Menus ob=new Menus();
			//ob.setUpMenus();
			Parking ob=new Parking();
			ob.SetUpParking();
		}
       else
      { 
		String dialogtittle="Invalid User ID or Password";
        	String dialogmessage="Error!";
		int dialogtype=JOptionPane.PLAIN_MESSAGE;
		dialogtype=JOptionPane.ERROR_MESSAGE;
		JOptionPane.showMessageDialog((Component)null,dialogtittle,dialogmessage,dialogtype);
	  }
	} 
	catch(Exception ex)
	{
		System.out.println("getBookRecord Error="+ex);
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
		System.exit(0);
	}
	else if(ae.getSource()==b3)
	{
		frm.setVisible(false);
		ForgotPassword ob=new ForgotPassword();
		ob.setUpForgotPassword();
	}
}
}


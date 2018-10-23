package mlcp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class UpdateParking extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
Choice ch1,ch2,ch3,ch4,ch5;
Checkbox c1,c2,c3;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20;
//imageIcon ic;

Connection con;
Statement stat;							
ResultSet rst;
PreparedStatement pst;

public UpdateParking()
{
l1=new JLabel("Parking id");
l2=new JLabel("owner name");
l3=new JLabel("RC number");
l4=new JLabel("Address");
l5=new JLabel("Contact no");
l6=new JLabel("time");
l7=new JLabel("Date");
l8=new JLabel("model");
l9=new JLabel("level no");
l10=new JLabel("track");
l11=new JLabel("status");
l12=new JLabel("");
l13=new JLabel("");

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

ch1=new Choice();

b1=new JButton("UPDATE");
b2=new JButton("SEARCH");

//dt=new Date();
//rd=new Random();
}

public void SetUpUpdateParking()
{
frm=new Frame("title");
frm.setLayout(null);
frm.setSize(2000,1500);

l1.setBounds(50,200,80,25);
frm.add(l1);
t1.setBounds(200,200,150,25);
//t1.setText(""+rd.nextInt( ));
frm.add(t1);


l2.setBounds(50,240,80,25);
frm.add(l2);
t2.setBounds(200,240,150,25);
frm.add(t2);

l3.setBounds(50,280,80,25);
frm.add(l3);
t3.setBounds(200,280,150,25);
frm.add(t3);

l4.setBounds(50,320,80,25);
frm.add(l4);
t4.setBounds(200,320,150,25);
frm.add(t4);

l5.setBounds(50,360,80,25);
frm.add(l5);
t5.setBounds(200,360,150,25);
frm.add(t5);

l6.setBounds(50,400,80,25);
frm.add(l6);
t6.setBounds(200,400,150,25);
frm.add(t6);

l7.setBounds(50,440,80,25);
frm.add(l7);
//t7.setText(" "+dt);
t7.setBounds(200,440,150,25);

//a14=t7.getText();
//a15=a14.substring(12,29);
//t6.setText(""+a15);

//a16=t7.getText();
//a17=a16.substring(0,11);
//t7.setText(" "+a17);
frm.add(t7);

l8.setBounds(50,480,80,25);
frm.add(l8);

ch1.setBounds(200,480,150,25);
frm.add(ch1);
ch1.add("select");
ch1.add("SUV");
ch1.add("SEDAN");
ch1.add("VAN");
ch1.add("COUPE");
ch1.add("WAGON");
ch1.add("CONVERTIBLE");
ch1.add("SPORTS CAR");
ch1.add("CROSSOVER");
ch1.add("HYBRID/ELECTRIC");
ch1.add("HATCHBACK");

l9.setBounds(50,520,80,25);
frm.add(l9);
t9.setBounds(200,520,150,25);
frm.add(t9);

l10.setBounds(50,560,80,25);
frm.add(l10);
t10.setBounds(200,560,150,25);
frm.add(t10);

l11.setBounds(50,600,80,25);
frm.add(l11);
t11.setBounds(200,600,150,25);
frm.add(t11);

//t12.setBounds(400,600,150,25);
//frm.add(t12);

b1.setBounds(200,640,150,25);
b1.addActionListener(this);
frm.add(b1);

b2.setBounds(400,640,150,25);
b2.addActionListener(this);
frm.add(b2);

l12.setBounds(50,700,80,25);
frm.add(l12);

l13.setBounds(50,740,80,25);
frm.add(l13);

connect();
//UpdateData();
//getTrackInfo();
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
a8=ch1.getSelectedItem();
a9=t9.getText();
a10=t10.getText();
a11=t11.getText();

}
catch(Exception ex)
{
System.out.println("Connection Error="+ex);
}
}

public void connect()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//it's a class (class name),and it's a prefix sentence
con=DriverManager.getConnection("jdbc:odbc:LMS");//jdbc=protocol & odbc=subprotocol
}
catch (Exception ex)
{
System.out.println("Connection Error="+ex);
}
}

public void searchData()
{ 
  a1=t1.getText();
	try
	{
		a2=t2.getText();
		stat=con.createStatement();
		rst=stat.executeQuery("select * from parking where parking id='"+a1+"'");
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


public void UpdateParking( )            
{
try
{
pst=con.prepareStatement("update parking set owner name='"+a2+"',RC number='"+a3+"',Address='"+a4+"',Contact no='"+a5+"',time='"+a6+"',date='"+a7+"',model='"+a8+"',level no='"+a9+"',track='"+a10+"',status='"+a11+"' where parking id='"+a1+"')");
pst.executeUpdate();
}
catch(Exception ex)
{
System.out.println("Error in insert="+ex);
}
}


public void actionPerformed(ActionEvent ae)
{

/*String Dialogtitle="Dialog";
String Dialogmessage1="PLZ FILL ALL entry g";
int dialogtype=JOptionPane.PLAIN_MESSAGE;
*/

if(ae.getSource()==b1)
{
       	getData();
	connect();
	UpdateParking();
	
	/*String dialogtittle="Detail Updated";
    	String dialogmessage="Great!";
	int dialogtype=JOptionPane.PLAIN_MESSAGE;
	 {
        dialogtype=JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog((Component)null,dialogtittle,dialogmessage,dialogtype);
}*/

}
/*if(a1.equals("") || a2.equals("") || a3.equals("") ||a4.equals("")||a5.equals("")||a6.equals("")||a7.equals("")||a8.equals("")||a9.equals("")||a10.equals("")||a11.equals("") )
{
l12.setText("plz fill all the field");
dialogtype=JOptionPane.ERROR_MESSAGE;
JOptionPane.showMessageDialog((Component) null,Dialogmessage1,Dialogtitle,dialogtype);
}
else
{
l13.setText("form succesfully submit");
connect();
putData();
}
*/
if(ae.getSource()==b2)
{
connect();
searchData();
}

}
}


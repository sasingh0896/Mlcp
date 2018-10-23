package mlcp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class AddLevel extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
Choice ch1,ch2,ch3,ch4,ch5;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
int n1,n2;
String ln,tn,a1,a2,a3,a4,a5="Available",a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20;				

Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;

public AddLevel()
{
l1=new JLabel("level No");
l2=new JLabel("Track No");

t1=new JTextField();
t2=new JTextField();

b1=new JButton("ADD");
b1.setToolTipText("add new level");
b2=new JButton("EX!T");
b2.setToolTipText("Click to close and do exit");
}
public void SetUpAddLevel()
{
frm=new Frame("Add new-level in future");
frm.setLayout(null);
frm.setSize(300,400);
frm.setLocation(300,200);

l1.setBounds(50,200,80,25);
frm.add(l1);
t1.setBounds(130,200,150,25);
frm.add(t1);

l2.setBounds(50,240,100,25);
frm.add(l2);
t2.setBounds(130,240,150,25);
frm.add(t2);

b1.setBounds(130,290,150,25);
b1.addActionListener(this);
frm.add(b1);

b2.setBounds(130,330,150,25);
b2.addActionListener(this);
frm.add(b2);

connect();
getAddLevel();
frm.setVisible(true);

}
public void connect()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");        //it's a class (class name),and it's a prefix sentence
con=DriverManager.getConnection("jdbc:odbc:LMS");      //jdbc=protocol & odbc=subprotocol
}
catch (Exception ex)
{
System.out.println("Connection Error="+ex);
}
}

public void getAddLevel()            
{
try
{
stat=con.createStatement();
rst=stat.executeQuery("select * from Trackinfo ");
while(rst.next())
{
a1=rst.getString(1);
a2=rst.getString(2);
}
t1.setText(""+a1);
t2.setText(""+a2);
}
catch(Exception ex)
{
System.out.println("getTrackRec Error="+ex);
}
}

public void insertNewLevel()
{
try
{
a3=t1.getText();
a4=t2.getText();
n1=Integer.parseInt(a3);
n2=Integer.parseInt(a4);
if(n2==10)
{
n1=n1+1;
n2=1;
}
else
{
n2=n2+1;
}
pst=con.prepareStatement("insert into Trackinfo (ln,tn,status) values ('"+n1+"','"+n2+"','"+a5+"')");
pst.executeUpdate();
t1.setText(""+n1);
t2.setText(""+n2);
}
catch(Exception ex)
{
System.out.println("getTrackRecord Error="+ex);
}
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
connect();
//getAddLevel();
insertNewLevel();
}
if(ae.getSource()==b2)
{
System.exit(0);
}

}
}
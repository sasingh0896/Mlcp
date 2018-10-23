package mlcp;
import java.sql.*;  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ParkingMap extends Frame implements ActionListener
{
Connection con;
Statement stat;
ResultSet rst;

String str1="Available",str2="Reserved";
Frame frm;
JLabel l[]=new JLabel[100];
//JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
//Choice ch1,ch2,ch3,ch4,ch5;
JButton b1;
String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;
ImageIcon ic;
int i,x=50,y=50,c=0,n1,n2;

public ParkingMap()
{
ic=new ImageIcon("green.png");
frm=new Frame("Parking Map");
b1=new JButton("close");
}

public void SetUpParkingMap()
{
frm.setLayout(null);
frm.setSize(600,800);
b1.setBounds(200,650,100,30);
for(i=0;i<100;i++)
{
c=c+1;
l[i]=new JLabel("l"+(i+1));
l[i]=new JLabel("",ic,JLabel.CENTER);
l[i].setBounds(x,y,50,70);
frm.add(l[i]);
x=x+50;
if(c==10)
{
y=y+60;
x=50;
c=0;
}
}
frm.add(b1);
frm.setVisible(true);
connect();
getTrackNo();
 b1.addActionListener(this);
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
System.out.println("connection error="+ex);
}
}

public void getTrackNo()
{
try
{
stat=con.createStatement();
rst=stat.executeQuery("select * from Trackinfo where STATUS='"+str2+"'");
while(rst.next())
{
n1=Integer.parseInt(rst.getString(1));
n2=Integer.parseInt(rst.getString(2));
i=10*(n1-1)+n2;
l[i-1].setIcon(new ImageIcon("red.png"));
}
}
catch(Exception ex)
{
System.out.println("getStuRecord Error="+ex);
}
}

public void actionPerformed(ActionEvent ae)
{
   if(ae.getSource()==b1)
   {
		//frm.setVisible(false);
		System.exit(0);
   }
}
}

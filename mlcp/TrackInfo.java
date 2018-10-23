package mlcp;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TrackInfo extends Frame implements ActionListener
{
Frame frm;
JLabel l[]=new JLabel[100];
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
Choice ch1,ch2,ch3,ch4,ch5;
Checkbox c1,c2,c3;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
//String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;
int i,x=0,y=0,c=0;

public TrackInfo()
{

}
public void SetUpParking()
{
frm=new Frame("title");
frm.setLayout(null);
frm.setSize(2000,1500);

for(i=0;i<=100;i++)
{
c=c+1;
l[i]=new JLabel();
l[i].setBounds(x,y,25,25);
frm.add(l[i]);
}

frm.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{

}
}
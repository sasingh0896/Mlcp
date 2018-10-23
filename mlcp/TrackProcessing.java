package mlcp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class TrackProcessing extends Frame implements ActionListener,Runnable
{
JTextField t3,t9,t10,t1,t2,t6;
JLabel l1,l2,l3,l4,l5,l6;
Frame frm;
String a1,a9,a10,k,l,a35,a36,a43;
JButton b1,b2,b3;
ImageIcon ic,ic1;
Thread th;

public TrackProcessing()                  
{
//ic1=new ImageIcon("t1.png");
l5=new JLabel("",ic,JLabel.RIGHT);
//ic=new ImageIcon("b1.png");
l4=new JLabel("",ic,JLabel.CENTER);
th=new Thread(this);
l1=new JLabel("Level No");
l2=new JLabel("Track No");
l3=new JLabel("proc");

t1=new JTextField("");
t2=new JTextField("");
t3=new JTextField();
t6=new JTextField();
b1=new JButton("print recipt1");
}

public void setUpTrackProcessing(String ln,String tn,String a35)
{

frm=new Frame("TrackProcessing");
frm.setLayout(null);
frm.setSize(2000,1500);
//frm.setLocation(200,100);

a9=ln;
a10=tn;
a36=a35;



//l1.setBounds(100,100,150,25);
//frm.add(l1);
t1.setBounds(150,100,170,25);
t1.setText(ln);
//frm.add(t1);

//l2.setBounds(100,200,150,25);
//frm.add(l2);
t2.setBounds(150,200,170,25);
t2.setText(tn);
//frm.add(t2);

l3.setBounds(100,150,150,25);
//frm.add(l3);
t3.setBounds(150,150,150,25);
//frm.add(t3);

l4.setBounds(0,0,800,800);
frm.add(l4);
l5.setBounds(0,0,1000,1000);
frm.add(l5);

b1.setBounds(150,640,150,25);
b1.addActionListener(this);
frm.add(b1);

frm.setVisible(true);
th.start();
}

public void run()
{
try
{

int n;

k=t1.getText();
n=Integer.parseInt(k);

for(int i=1;i<=n;i++)
{
if(i==1)
{
ic=new ImageIcon("b1.png");
}
if(i==2)
{
ic=new ImageIcon("b2.png");
}
if(i==3)
{
ic=new ImageIcon("b3.png");
}
if(i==4)
{
ic=new ImageIcon("b4.png");
}
if(i==5)
{
ic=new ImageIcon("b5.png");
}
if(i==6)
{
ic=new ImageIcon("b6.png");
}
if(i==7)
{
ic=new ImageIcon("b7.png");
}
if(i==8)
{
ic=new ImageIcon("b8.png");
}
if(i==9)
{
ic=new ImageIcon("b9.png");
}
if(i==10)
{
ic=new ImageIcon("b10.png");
}
t3.setText(""+i);
l4.setIcon(ic);

Thread.sleep(500);
}


int m;
l=t2.getText();
m=Integer.parseInt(l);


for(int j=1;j<=m;j++)
{
if(j==1)
{
ic1=new ImageIcon("t1.png");
}
if(j==2)
{
ic1=new ImageIcon("t2.png");
}
if(j==3)
{
ic1=new ImageIcon("t3.png");
}
if(j==4)
{
ic1=new ImageIcon("t4.png");
}
if(j==5)
{
ic1=new ImageIcon("t5.png");
}
if(j==6)
{
ic1=new ImageIcon("t6.png");
}
if(j==7)
{
ic1=new ImageIcon("t7.png");
}
if(j==8)
{
ic1=new ImageIcon("t8.png");
}
if(j==9)
{
ic1=new ImageIcon("t9.png");
}
if(j==10)
{
ic1=new ImageIcon("t10.png");
}
l5.setIcon(ic1);
t6.setText(""+j);
Thread.sleep(500);
}

}
catch(Exception ex)
{
System.out.println(ex);
}
}
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{
	//frm.setVisible(false);
        ParkingRecipt1 ob=new ParkingRecipt1();
        ob.setUpParkingRecipt1(a36);
	}
	
}

}
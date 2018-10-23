package mlcp;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class CreateAccountmlcp extends Frame implements ActionListener
{
Frame frm;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
TextField t1,t2,t3,t4,t5,t6;
Choice ch1,ch2,ch3,ch4,ch5;
Button b1,b2,b3,b4;
Checkbox c1,c2,c3;
String a1,a2,a3,a4,a5;

Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;

public CreateAccountmlcp()
{
l1=new Label("User Id");
l2=new Label("password");
l3=new Label("re password");
l4=new Label("select question");
l5=new Label("");

t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();
ch1=new Choice();
ch2=new Choice();
b1=new Button("SAVE");
b2=new Button("CLOSE");
}

public void SetUpCreateAccountmlcp()
{

frm=new Frame("title");
frm.setLayout(null);
frm.setSize(800,800);
l1.setBounds(50,100,50,25);
frm.add(l1);
t1.setBounds(150,100,150,25);
frm.add(t1);

l2.setBounds(50,140,80,25);
frm.add(l2);
t2.setBounds(150,140,150,25);
frm.add(t2);

l3.setBounds(50,180,80,25);
frm.add(l3);
t3.setBounds(150,180,150,25);
frm.add(t3);

l4.setBounds(50,210,100,30);
frm.add(l4);
t4.setBounds(180,210,100,22);
ch1.setBounds(180,210,100,30);
frm.add(ch1);
ch1.add("animals");
ch1.add("cars");
ch1.add("human");
frm.add(t4);

l5.setBounds(200,350,170,50);
frm.add(l5);
t5.setBounds(300,210,100,25);
frm.add(t5);

b1.setBounds(60,280,150,25);
b1.addActionListener(this);
frm.add(b1);

b2.setBounds(220,280,150,25);
b2.addActionListener(this);
frm.add(b2);
frm.setVisible(true);
}

public void getData()
{
try
{
a1=t1.getText();
a2=t2.getText();
a3=t3.getText();
a4=ch1.getSelectedItem();
a5=t5.getText();
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

public void putData()
{
try
{
pst=con.prepareStatement("insert into createAccountmlcp values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"')");
pst.executeUpdate();
}
catch (Exception ex)
{
System.out.println("insertion error="+ex);
}
}
public void actionPerformed(ActionEvent ae)
{


if(ae.getSource()==b1)
{
getData();

if(a1.equals("") || a2.equals("") || a3.equals("") ||a4.equals("") )
{
l5.setText("plz put right data");
}
else
{
l5.setText("form succesfully submit");
}
}
if(ae.getSource()==b2)
{
frm.setVisible(false);
}
connect();
putData();
}
}
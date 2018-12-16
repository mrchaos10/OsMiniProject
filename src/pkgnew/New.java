/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;
import java.sql.*;  
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.*;  
import javax.swing.*; 
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random ;
class DES {
byte[] skey = new byte[1000];
String skeyString;
static byte[] raw;
String inputMessage,encryptedData,decryptedMessage;

public DES(String x) {
try {
generateSymmetricKey();

//inputMessage=JOptionPane.showInputDialog(null,"Enter message to encrypt");
String inputMessage=x;
byte[] ibyte = inputMessage.getBytes();
byte[] ebyte=encrypt(raw, ibyte);
String encryptedData = new String(ebyte);
System.out.println("Encrypted message "+encryptedData);
JOptionPane.showMessageDialog(null,"Encrypted Data "+"\n"+encryptedData);

byte[] dbyte= decrypt(raw,ebyte);
String decryptedMessage = new String(dbyte);
System.out.println("Decrypted message "+decryptedMessage);

JOptionPane.showMessageDialog(null,"Decrypted Data "+"\n"+decryptedMessage);
}
catch(Exception e) {
System.out.println(e);
}

}
void generateSymmetricKey() {
try {
Random r = new Random();
int num = r.nextInt(10000);
String knum = String.valueOf(num);
byte[] knumb = knum.getBytes();
skey=getRawKey(knumb);
skeyString = new String(skey);
System.out.println("DES Symmetric key = "+skeyString);
}
catch(Exception e) {
System.out.println(e);
}
}
private static byte[] getRawKey(byte[] seed) throws Exception {
KeyGenerator kgen = KeyGenerator.getInstance("DES");
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
sr.setSeed(seed);
kgen.init(56, sr);
SecretKey skey = kgen.generateKey();
raw = skey.getEncoded();
return raw;
}
private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
Cipher cipher = Cipher.getInstance("DES");
cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
byte[] encrypted = cipher.doFinal(clear);
return encrypted;
}

private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
Cipher cipher = Cipher.getInstance("DES");
cipher.init(Cipher.DECRYPT_MODE, skeySpec);
byte[] decrypted = cipher.doFinal(encrypted);
return decrypted;
}

}

class RandomGenerator {
public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    
}

class StrongAes 
{
    String enc;
    String decrypted;
       public void run(String text) 
    {
        try 
        {
            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b: encrypted) {
                sb.append((char)b);
            }

            // the encrypted String
            enc = sb.toString();
            
            // now convert the string to byte array
            // for decryption
            byte[] bb = new byte[enc.length()];
            for (int i=0; i<enc.length(); i++) {
                bb[i] = (byte) enc.charAt(i);
            }

            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            decrypted = new String(cipher.doFinal(bb));
            

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}

class Sqlexamp{  
public void dbman(String uname,String pwd){  
try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","batman");  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  
      
ResultSet rs=stmt.executeQuery("select * from pexamp");  
while(rs.next())  
{
    String x=rs.getString(1);
    String y=rs.getString(2);
    
    if(x.equals(uname) && y.equals(pwd))
    {
        System.out.println("DATA FOUND");
        ResultSet rs1=stmt.executeQuery("select * from CREDENTIALS");  
        
        while(rs1.next())
        {
            String x1=rs1.getString(1);
            String x2=rs1.getString(2);
            String x3=rs1.getString(3);
            String x4=rs1.getString(4);
            String x5=rs1.getString(5);
            String x6=rs1.getString(6);
            String x7=rs1.getString(7);
            String x8=rs1.getString(8);
            String x9=rs1.getString(9);
            String x10=rs1.getString(10);
                 if(x.equals(x1))
                 {
                     
                     JFrame f= new JFrame("TextField Example");  
                      f.add(new JPanel(), BorderLayout.NORTH);
                       f.add(new JScrollPane(), BorderLayout.NORTH);


       
 
 JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;  
    t1=new JTextField(x1);  
    t1.setBounds(50,100, 200,30);  
    t2=new JTextField(x2);  
    t2.setBounds(50,150, 200,30);  
    t3=new JTextField(x3);  
    t3.setBounds(50,200, 200,30);  
    t4=new JTextField(x4);  
    t4.setBounds(50,250, 200,30);  
    t5=new JTextField(x5);  
    t5.setBounds(50,300, 200,30);  
    t6=new JTextField(x6);  
    t6.setBounds(50,350, 200,30);  
    t7=new JTextField(x7);  
    t7.setBounds(50,400, 200,30);  
    t8=new JTextField(x8);  
    t8.setBounds(50,450, 200,30);  
    t10=new JTextField(x9);  
    t10.setBounds(300,450,200,30);  
            t9=new JTextField(x10);  
    t9.setBounds(50,500, 200,30);  

    
    f.add(t1); f.add(t2);f.add(t3);f.add(t4);f.add(t5);f.add(t6);f.add(t7);f.add(t8);f.add(t9);f.add(t10);
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;  
    l1=new JLabel("Your AADHAR Number.");  
    l1.setBounds(50,50, 1000,57);  
    l2=new JLabel("Your Passport Number.");  
    l2.setBounds(50,100, 1000,80);  
    l3=new JLabel("Your Electoral Photo Identity Number.");  
    l3.setBounds(50,100, 1000,180);  
    l4=new JLabel("Your Driving License Number");  
    l4.setBounds(50,100, 1000,280);  
    l5=new JLabel("Your Ration Card Number.");  
    l5.setBounds(50,100, 1000,370);  
    l6=new JLabel("Your  Birth Certificate Registration Number.");  
    l6.setBounds(50,100, 1000,480);  
    l7=new JLabel("Your School Leaving Certificate(TC) Number.");  
    l7.setBounds(50,100, 1000,580);  
    l8=new JLabel("Your Bank Account Number. and Your bank name in the next textfield");  
    l8.setBounds(50,100, 1000,680);  
    l9=new JLabel("Your ATM CARD NUMBER .");  
    l9.setBounds(50,100, 1000,780);  
    
    f.add(l1); f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);f.add(l8);f.add(l9);
    f.setSize(1000,1000);  
    f.setLayout(null);  
    f.setVisible(true);  

                     //  System.out.println(x1+x2+x3+x4+x5+x6+x7+x8+x9+x10);
                 }
            
            
        }
    break;
    }
    else
        System.out.println("DATA NOT FOUND");
    
}   
        
  
//step5 close the connection object  
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}  
}  

class Editpad {
        public  void run() {
JFrame f= new JFrame("TextField Example");  
f.add(new JPanel(), BorderLayout.NORTH);
f.add(new JScrollPane(), BorderLayout.NORTH);


       
 
 JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;  
    t1=new JTextField("");  
    t1.setBounds(50,100, 200,30);  
    t2=new JTextField("");  
    t2.setBounds(50,150, 200,30);  
    t3=new JTextField("");  
    t3.setBounds(50,200, 200,30);  
    t4=new JTextField("");  
    t4.setBounds(50,250, 200,30);  
    t5=new JTextField("");  
    t5.setBounds(50,300, 200,30);  
    t6=new JTextField("");  
    t6.setBounds(50,350, 200,30);  
    t7=new JTextField("");  
    t7.setBounds(50,400, 200,30);  
    t8=new JTextField("");  
    t8.setBounds(50,450, 200,30);  
    t10=new JTextField("");  
    t10.setBounds(300,450,200,30);  
            t9=new JTextField("");  
    t9.setBounds(50,500, 200,30);  
t11=new JTextField("");  
    t11.setBounds(50,550, 200,30);  

    
    f.add(t1); f.add(t2);f.add(t3);f.add(t4);f.add(t5);f.add(t6);f.add(t7);f.add(t8);f.add(t9);f.add(t10);
    f.add(t11);
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;  
    l1=new JLabel("Enter The AADHAR Number.");  
    l1.setBounds(50,50, 1000,57);  
    l2=new JLabel("Enter The Passport Number.");  
    l2.setBounds(50,100, 1000,80);  
    l3=new JLabel("Enter The Electoral Photo Identity Number.");  
    l3.setBounds(50,100, 1000,180);  
    l4=new JLabel("Enter The Driving License Number");  
    l4.setBounds(50,100, 1000,280);  
    l5=new JLabel("Enter The Ration Card Number.");  
    l5.setBounds(50,100, 1000,370);  
    l6=new JLabel("Enter The  Birth Certificate Registration Number.");  
    l6.setBounds(50,100, 1000,480);  
    l7=new JLabel("Enter The School Leaving Certificate(TC) Number.");  
    l7.setBounds(50,100, 1000,580);  
    l8=new JLabel("Enter Your Bank Account Number. and Enter your bank name in the next textfield");  
    l8.setBounds(50,100, 1000,680);  
    l9=new JLabel("Enter Your ATM CARD NUMBER .");  
    l9.setBounds(50,100, 1000,780);  
    l10=new JLabel("Enter your password.");  
    l10.setBounds(50,100, 1000,880);  
    
    f.add(l1); f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);f.add(l8);f.add(l9);f.add(l10);
    f.setSize(1000,1000);  
    f.setLayout(null);  
    f.setVisible(true);  
   JButton b=new JButton("Click Here to register");  
    b.setBounds(500,100,100,100);  
    f.add(b);
    b.addActionListener(new ActionListener(){  
@Override
public void actionPerformed(ActionEvent e){ 
    
try{  
    

//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","batman");  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  

String uname=t1.getText();
String s1=t2.getText();
String s2=t3.getText();
String s3=t4.getText();
String s4=t5.getText();
String s5=t6.getText();
String s6=t7.getText();
String s7=t8.getText();
String s8=t10.getText();
String s9=t9.getText();
String pwd=t11.getText();

        StrongAes a1 = new StrongAes();
        a1.run(uname);
        StrongAes a2 = new StrongAes();
        a2.run(s1);  
        StrongAes a3 = new StrongAes();
        a3.run(s2);
        StrongAes a4 = new StrongAes();
        a4.run(s3);
        StrongAes a5 = new StrongAes();
        a5.run(s4);
        StrongAes a6 = new StrongAes();
        a6.run(s5);
        StrongAes a7 = new StrongAes();
        a7.run(s6);
        StrongAes a8 = new StrongAes();
        a8.run(s7);
        StrongAes a9 = new StrongAes();
        a9.run(s8);
        StrongAes a10 = new StrongAes();
        a10.run(s9);
        StrongAes a11 = new StrongAes();
        a11.run(pwd);

        DES des1 = new DES(uname);
        DES des2 = new DES(s1);
DES des3 = new DES(s2);
DES des4 = new DES(s3);
DES des5 = new DES(s4);
DES des6 = new DES(s5);
DES des7 = new DES(s6);
DES des8 = new DES(s7);
DES des9 = new DES(s8);
DES des10 = new DES(s9);
DES des11= new DES(pwd);


        System.out.println("SET OF ALL ENCRYPTED VALUES :");
System.out.println(a1.enc+a1.decrypted+"\n");
System.out.println(a2.enc+a2.decrypted+"\n");
System.out.println(a3.enc+a3.decrypted+"\n");
System.out.println(a4.enc+a4.decrypted+"\n");
System.out.println(a5.enc+a5.decrypted+"\n");
System.out.println(a6.enc+a6.decrypted+"\n");
System.out.println(a7.enc+a7.decrypted+"\n");
System.out.println(a8.enc+a8.decrypted+"\n");
System.out.println(a9.enc+a9.decrypted+"\n");
System.out.println(a10.enc+a10.decrypted+"\n");
System.out.println(a11.enc+a11.decrypted+"\n");


String sql = "INSERT INTO pexamp " +
                   "VALUES ('"+uname+"', '"+pwd+"')";
    String sql1 = "INSERT INTO CREDENTIALS "+"VALUES ('"+uname+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"')";
         
      stmt.executeUpdate(sql1);
       stmt.executeUpdate(sql);
  System.out.println("REGISTRATION DONE SUCCESSFULLY");
JFrame ff= new JFrame("TextField Example");  
ff.add(new JPanel(), BorderLayout.NORTH);
ff.add(new JScrollPane(), BorderLayout.NORTH);
JTextField t1,t2;  
    t1=new JTextField(uname);  
    t1.setBounds(50,100, 200,30);  
    t2=new JTextField(pwd);  
    t2.setBounds(50,150, 200,30);  
 
ff.add(t1); ff.add(t2);
    JLabel l1,l2;  
    l1=new JLabel("Your USERNAME IS");  
    l1.setBounds(50,50, 1000,57);  
    l2=new JLabel("Your Password is.");  
    l2.setBounds(50,100, 1000,80);  

    ff.add(l1);ff.add(l2);
   ff.setSize(1000,1000);  
    ff.setLayout(null);  
    ff.setVisible(true);  
String sql2 = "INSERT INTO CREDENTIALSdup "+"VALUES ('"+a1.enc+"','"+a2.enc+"','"+a3.enc+"','"+a4.enc+"','"+a5.enc+"','"+a6.enc+"','"+a7.enc+"','"+a8.enc+"','"+a9.enc+"','"+a10.enc+"')";
    stmt.executeUpdate(sql2);
      
       con.close();  
    
}catch(Exception el){ System.out.println(el);}  

}    
});
    
    }
}




public class  New{


     static int a;
     public static void main(String [] args) {
   JFrame f=new JFrame("Button Example");  
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   JLabel l1,l2,l3;
   JTextField tf,t2,t3;
   RandomGenerator r =new RandomGenerator();
     String sx=r.getSaltString();
     String sub=sx.substring(1,7);
    l1=new JLabel("Enter The USERID(YOU KNOW WHATS IT IF U HAVE ALREADY SIGNED UP)");  
    l1.setBounds(50,50, 1000,15);  
    
     tf=new JTextField();  
     tf.setBounds(50,80, 150,20);  
    l2=new JLabel("Enter The Password.");  
    l2.setBounds(50,50, 1000,150);  
     
     t2=new JTextField("");  
     t2.setBounds(50,150, 150,20);  
    
    l3=new JLabel(sub);  
    
    l3.setBounds(50,50, 1000,250);  
     
     t3=new JTextField("");  
     t3.setBounds(50,250, 150,20);  
        
    
    JButton b1=new JButton("LOG__IN");  
    b1.setBounds(50,200,95,30);  
     
      JButton b2=new JButton("SIGN__UP");  
    b2.setBounds(50,300,95,30);

     JCheckBox checkBox7 = new JCheckBox("Verify Captcha", true);  
     checkBox7.setBounds(100,400, 50,50); 
          
         
checkBox7.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                          a=1;       
                      else
                          a=0;
                    
                
            }
        });

b1.addActionListener(new ActionListener(){  
@Override
public void actionPerformed(ActionEvent e1){  
Sqlexamp ex=new Sqlexamp();
String uname = tf.getText();
String pwd = t2.getText();

if(a==1)
{
ex.dbman(uname,pwd);
}  
}  });
    b2.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
       Editpad ep= new Editpad();
           ep.run();

}  
    });  
    f.add(l1);
    f.add(tf);  
    
    f.add(l2);
    f.add(t2);
    
    f.add(l3);
    f.add(t3);
    
    f.add(b1);
    f.add(b2);
   
    f.add(checkBox7);
    f.setSize(600,400);  
    f.setLayout(new GridLayout(0,1));  
    f.setVisible(true);               
    }
  
    }

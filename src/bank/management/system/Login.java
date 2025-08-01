package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){



        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,30));
        text.setBounds(200,50,400,35);
        add(text);

        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,30);
        add(cardTextField);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,225,250,30);
        add(pinTextField);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(120,220,400,40);
        add(pin);

        add(label);

        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        getContentPane().setBackground(Color.WHITE);

        setSize(800,500);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed (ActionEvent ae){
          if(ae.getSource()==clear){
                 cardTextField.setText("");
                 pinTextField.setText("");
          } else if(ae.getSource()==login){

              Conn conn=new Conn();
              String cardNumber=cardTextField.getText();
              String pinnumber=pinTextField.getText();
              String query="select * from login where cardnumber= '"+cardNumber+"' and pinNumber='"+pinnumber+"'";
             try{
                ResultSet rs= conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
             }catch(Exception e){
                 System.out.println(e);
             }

          }else if(ae.getSource()==signup){
          setVisible(false);
          new SignupOne().setVisible(true);
          }
    }
    public static void main(String[] args){
        new Login();
    }

}

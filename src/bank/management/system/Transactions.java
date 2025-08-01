package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdraw,ministatement,pinChange,fastcash,balanceEnquiry,exit;
     String pinnumber;



    Transactions(String pinnumber){
       this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);

        add(image);

        JLabel text=new JLabel("Please your transaction");
        text.setBounds(235,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(170,395,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw=new JButton("Cash Withdraw");
        withdraw.setBounds(355,395,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash=new JButton("Fast Cards");
        fastcash.setBounds(170,430,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,430,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinChange=new JButton("Pin Change");
        pinChange.setBounds(170,465,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry=new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,465,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit=new JButton("Exit");
        exit.setBounds(355,500,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);




    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
         setVisible(false);
         new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdraw){
         setVisible(false);
         new Withdraw(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
         setVisible(false);
         new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinChange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args){
          new Transactions("");
    }
}


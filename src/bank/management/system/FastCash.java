package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {
    JButton hundred,five,fivek,two,thousand,tenk,exit;
    String pinnumber;



    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);

        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(235,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("System",Font.BOLD,16));
        image.add(text);

        hundred=new JButton("Rs 100");
        hundred.setBounds(170,395,150,30);
        hundred.addActionListener(this);
        image.add(hundred);

        five=new JButton("Rs 500");
        five.setBounds(355,395,150,30);
        five.addActionListener(this);
        image.add(five);

        thousand=new JButton("Rs 1000");
        thousand.setBounds(170,430,150,30);
        thousand.addActionListener(this);
        image.add(thousand);

        two=new JButton("Rs 2000");
        two.setBounds(355,430,150,30);
        two.addActionListener(this);
        image.add(two);

        fivek=new JButton("Rs 5000");
        fivek.setBounds(170,465,150,30);
        fivek.addActionListener(this);
        image.add(fivek);

        tenk=new JButton("Rs 10000");
        tenk.setBounds(355,465,150,30);
        tenk.addActionListener(this);
        image.add(tenk);

        exit=new JButton("Back");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));

                    }
                    else{
                        balance-=Integer.parseInt(rs.getString("amount"));

                    }
                }
                if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" debited successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args){
        new FastCash("");
    }
}


package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);


        JLabel label=new JLabel("Page 3: Account Details");
        label.setFont(new Font("Raleway", Font.BOLD,22));
        label.setBounds(300,40,400,40);
        add(label);

        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,200,20);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,200,20);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup group=new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);

        JLabel card=new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-4104");
        number.setFont(new Font("Raleway", Font.BOLD,22));
        number.setBounds(330,300,260,30);
        add(number);

        JLabel cardDetails=new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway", Font.BOLD,12));
        cardDetails.setBounds(100,330,300,20);
        add(cardDetails);

        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD,22));
        pnumber.setBounds(330,370,260,30);
        add(pnumber);

        JLabel pinDetails=new JLabel("Your 4 Digit Password");
        pinDetails.setFont(new Font("Raleway", Font.BOLD,12));
        pinDetails.setBounds(100,400,300,20);
        add(pinDetails);

        JLabel services =new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,200,30);
        add(services);

        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4=new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7=new JCheckBox("I hereby declare that the above entered details are true to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(100,680,800,30);
        add(c7);

        submit =new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel =new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
           String account=null;
           if(r1.isSelected()){
               account="Saving Account";
           }
           else if(r2.isSelected()){
               account="Fixed Deposit Account";
           }
           else if(r3.isSelected()){
               account="Current Account";
           }
           else if(r4.isSelected()){
               account="Recurring Deposit Account";
           }
         Random random=new Random();
           String cardNo=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
           String pinNumber=""+Math.abs((random.nextLong()%9000L)+1000L);
           String facility="";
           if(c1.isSelected()){
               facility=facility+"ATM Card";
           }
           else if(c2.isSelected()){
               facility=facility+"Internet Banking";
           }
           else if(c3.isSelected()){
               facility=facility+"Mobile Banking";
           }
           else if(c4.isSelected()){
               facility=facility+"EMAIL & SMS Alerts";
           }
           else if(c5.isSelected()){
               facility=facility+"Cheque Book";
           }
           else if(c6.isSelected()){
               facility=facility+"E-Statement";
           }
           try{
              if(account.equals("")){
                  JOptionPane.showMessageDialog(null,"Account type is required");
              }
              if(facility.equals("")){
                  JOptionPane.showMessageDialog(null,"Mention any of the given services");
              }
              else{
                  Conn conn=new Conn();

                  String query1 = "insert into signupthree values('"+formno+"','"+account+"','"+cardNo+"','"+pinNumber+"','"+facility+"')";
                 String query2="insert into login values('"+formno+"','"+cardNo+"','"+pinNumber+"')";
                  conn.s.executeUpdate(query1);
                  conn.s.executeUpdate(query2);

                 JOptionPane.showMessageDialog(null,"Card number: "+cardNo+"\n Pin: "+pinNumber);

                 setVisible(false);
                 new Deposit(pinNumber).setVisible(true);
              }
           }
           catch(Exception e){
               System.out.println(e);
           }
        }

        else if (ae.getSource()==cancel){
           setVisible(false);
           new Login().setVisible(true);
        }

    }

    public static void main(String[] args){
        new SignupThree("");
    }
}

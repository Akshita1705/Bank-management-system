package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(250,200,500,35);
        image.add(text);

        JLabel pinText=new JLabel("NEW PIN");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System",Font.BOLD,16));
        pinText.setBounds(165,320,100,25);
        image.add(pinText);

       pin=new JPasswordField();
       pin.setFont(new Font("Raleway",Font.BOLD,25));
       pin.setBounds(330,320,180,25);
       image.add(pin);

       JLabel repintext=new JLabel("Re-enter New PIN:");
       repintext.setForeground(Color.WHITE);
       repintext.setFont(new Font("System",Font.BOLD,16));
       repintext.setBounds(165,360,180,25);
       image.add(repintext);

        repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        change=new JButton("CHANGE");
        change.setBounds(355,480,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("BACK");
        back.setBounds(355,515,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
       setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
                String spin=pin.getText();
                String rpin=pin.getText();

                if(!spin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered pin does not match");
                    return;

                }
                if(spin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter a PIN.");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter the PIN.");
                    return;
                }
                Conn c=new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null,"PIN changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }


    }
    public static void main(String[] args){
    new PinChange("").setVisible(true);
    }
}

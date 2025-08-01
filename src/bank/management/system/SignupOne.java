package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
   JTextField nameText,fnameText,emailText,adrText,cityText,stateText,pinText;
   JRadioButton male,fmale,yesm,nom;
   JButton next;
   JDateChooser dateChooser;

    SignupOne(){
        setLayout(null);
        Random rno=new Random();
        random=Math.abs((rno.nextLong()%9000L)+1000L);
        JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personDetails=new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,90,400,30);
        add(personDetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);

        nameText=new JTextField();
        nameText.setFont(new Font("Raleway",Font.BOLD,14));
        nameText.setBounds(300,150,400,20);
        add(nameText);

        JLabel fname=new JLabel("Father's name:");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameText=new JTextField();
        fnameText.setFont(new Font("Raleway",Font.BOLD,14));
        fnameText.setBounds(300,200,400,20);
        add(fnameText);

        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,20);
        add(dateChooser);

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        fmale=new JRadioButton("Female");
        fmale.setBounds(450,290,90,30);
        fmale.setBackground(Color.WHITE);
        add(fmale);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(fmale);
        genderGroup.add(male);

        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);

        emailText=new JTextField();
        emailText.setFont(new Font("Raleway",Font.BOLD,14));
        emailText.setBounds(300,350,400,20);
        add(emailText);

        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,390,200,30);
        add(marital);

         yesm=new JRadioButton("Married");
        yesm.setBounds(300,390,80,30);
        yesm.setBackground(Color.WHITE);
        add(yesm);

        nom=new JRadioButton("Unmarried");
        nom.setBounds(450,390,90,30);
        nom.setBackground(Color.WHITE);
        add(nom);

        ButtonGroup marGroup=new ButtonGroup();
        marGroup.add(yesm);
        marGroup.add(nom);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);

        adrText=new JTextField();
        adrText.setFont(new Font("Raleway",Font.BOLD,14));
        adrText.setBounds(300,450,400,20);
        add(adrText);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);

        cityText=new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD,14));
        cityText.setBounds(300,500,400,20);
        add(cityText);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);

        stateText=new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD,14));
        stateText.setBounds(300,550,400,20);
        add(stateText);

        JLabel pin=new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,590,200,30);
        add(pin);

        pinText=new JTextField();
        pinText.setFont(new Font("Raleway",Font.BOLD,14));
        pinText.setBounds(300,600,400,20);
        add(pinText);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


       getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+random; //long
        String name=nameText.getText();
        String fname=fnameText.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected())
            gender="Male";
        else gender="Female";
        String email=emailText.getText();
        String marital=null;
        if(yesm.isSelected()) marital="Married";
        else marital="Unmarried";
        String address=adrText.getText();
        String city=cityText.getText();
        String state=stateText.getText();
        String pin=pinText.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else {
                Conn c=new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"','"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
         System.out.println(e);
        }
    }
    public static void main(String[] args){
        new SignupOne();
    }
}

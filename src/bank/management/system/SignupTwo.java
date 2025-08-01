package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField panText,aadharText;
    JRadioButton yess,nos,eas,ean;
    JComboBox religion,category,income,education,occupation;
    JButton next;
    String formno;

    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel addDetails=new JLabel("Page 2: Additional Details");
        addDetails.setFont(new Font("Raleway",Font.BOLD,22));
        addDetails.setBounds(290,90,400,30);
        add(addDetails);

        JLabel religion_name=new JLabel("Religion:");
        religion_name.setFont(new Font("Raleway",Font.BOLD,22));
        religion_name.setBounds(100,140,100,30);
        add(religion_name);

        String []rel={"Hindu","Muslim","Sikh","Christian","Others"};
        religion =new JComboBox(rel);
        religion.setBounds(300,150,400,20);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel cat_name=new JLabel("Category:");
        cat_name.setFont(new Font("Raleway",Font.BOLD,22));
        cat_name.setBounds(100,190,200,30);
        add(cat_name);

        String cat[]={"General","OBC","BC","SC","ST","Others"};
        category=new JComboBox(cat);
        category.setBounds(300,200,400,20);
        category.setBackground(Color.WHITE);
        add(category);


        JLabel income_lpa=new JLabel("Income:");
        income_lpa.setFont(new Font("Raleway",Font.BOLD,22));
        income_lpa.setBounds(100,240,200,30);
        add(income_lpa);

        String[] inc={"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income=new JComboBox(inc);
        income.setBounds(300,240,400,20);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel qualify=new JLabel("Educational");
        qualify.setFont(new Font("Raleway",Font.BOLD,22));
        qualify.setBounds(100,310,200,30);
        add(qualify);


        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,340,200,30);
        add(qualification);

        String []edu={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        education=new JComboBox(edu);
        education.setBounds(300,325,400,20);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occupy=new JLabel("Occupation:");
        occupy.setFont(new Font("Raleway",Font.BOLD,22));
        occupy.setBounds(100,390,200,30);
        add(occupy);

        String []occ={"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupation=new JComboBox(occ);
        occupation.setBounds(300,390,400,20);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel pan=new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        pan.setBounds(100,440,200,30);
        add(pan);

        panText=new JTextField();
        panText.setFont(new Font("Raleway",Font.BOLD,14));
        panText.setBounds(300,450,400,20);
        add(panText);

        JLabel aadhar=new JLabel("AADHAR Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,22));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);

        aadharText=new JTextField();
        aadharText.setFont(new Font("Raleway",Font.BOLD,14));
        aadharText.setBounds(300,500,400,20);
        add(aadharText);

        JLabel scitizen=new JLabel("Senior Citizen:");
        scitizen.setFont(new Font("Raleway",Font.BOLD,22));
        scitizen.setBounds(100,540,200,30);
        add(scitizen);

        yess=new JRadioButton("Yes");
        yess.setBounds(300,550,90,20);
        yess.setBackground(Color.WHITE);
        add(yess);

        nos=new JRadioButton("No");
        nos.setBounds(450,550,90,20);
        nos.setBackground(Color.WHITE);
        add(nos);

        ButtonGroup group=new ButtonGroup();
        group.add(yess);
        group.add(nos);


        JLabel acc=new JLabel("Existing Account:");
        acc.setFont(new Font("Raleway",Font.BOLD,22));
        acc.setBounds(100,590,200,30);
        add(acc);


        eas=new JRadioButton("Yes");
        eas.setBounds(300,600,90,20);
        eas.setBackground(Color.WHITE);
        add(eas);

        ean=new JRadioButton("No");
        ean.setBounds(450,600,90,20);
        ean.setBackground(Color.WHITE);
        add(ean);

        ButtonGroup group2=new ButtonGroup();
        group2.add(eas);
        group2.add(ean);


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
//        String formno=""; //long
       String sreligion=(String)religion.getSelectedItem();
        String scategory =(String)category.getSelectedItem();;
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(yess.isSelected())
            seniorcitizen="Yes";
        else seniorcitizen="No";

        String existingaccount=null;
        if(eas.isSelected()) existingaccount="Yes";
        else existingaccount="No";


        String span=panText.getText();
        String saadhar=aadharText.getText();
        if (!span.matches("^[A-Z]{5}[0-9]{4}[A-Z]$")) {
            JOptionPane.showMessageDialog(null, "Invalid PAN number. Format should be: 5 letters, 4 digits, 1 letter (e.g., ABCDE1234F)");
            return;
        }

        if (!saadhar.matches("^[1-9][0-9]{11}$")) {
            JOptionPane.showMessageDialog(null, "Invalid Aadhar number. It must be exactly 12 digits and cannot start with 0.");
             return;
        }

        try{
                 Conn c=new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"','"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);


                setVisible(false);
                new SignupThree(formno).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new SignupTwo("");
    }
}

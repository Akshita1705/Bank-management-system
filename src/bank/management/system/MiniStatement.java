package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        setLayout(null);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 200, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 60, 350, 20);

        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 450, 350, 20);
        add(balance);

        JTextArea text = new JTextArea();
        text.setEditable(false);
        text.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setBounds(20, 100, 350, 300);
        add(scrollPane);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE pinNumber = '" + pinnumber + "'");
            if (!rs.next()) {
                System.out.println("No record found for pin: " + pinnumber);
            } else {
                String cardnum = rs.getString("cardnumber");
                System.out.println("Card from DB: " + cardnum);
                card.setText("Card Number: " + cardnum.substring(0, 4) + " **** **** " + cardnum.substring(12));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            int value = 0;
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                String line = rs.getString("date") + "   " + rs.getString("type") + "   Rs" + rs.getString("amount");
                text.append(line + "\n\n");
                if (rs.getString("type").equals("Deposit")) {
                    value += Integer.parseInt(rs.getString("amount"));
                } else {
                    value -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs " + value);
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 550);
        setLocation(100, 100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args){
        new MiniStatement("");
    }
}

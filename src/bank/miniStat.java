package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class miniStat extends JFrame implements ActionListener{

    JButton exitButton;

    String pass;

    miniStat(String pass){
        super("Mini Statement");

        this.pass = pass;

        JLabel label1 = new JLabel();
        label1.setBounds(50,20,450,30);
        label1.setFont(new Font("System",Font.BOLD,18));
        add(label1);

        JLabel label2 = new JLabel();
        label2.setBounds(50,280,450,30);
        label2.setFont(new Font("System",Font.BOLD,17));
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(50,40,450,300);
        label3.setFont(new Font("System",Font.BOLD,14));
        add(label3);

        try {
            dbconn mDbconn = new dbconn();
            ResultSet res = mDbconn.statement.executeQuery("SELECT * FROM user_pass WHERE pass = '"+pass+"';");
            while (res.next()) {
                label1.setText("Card Number XXXX-XXXX-XXXX-"+res.getString("card_no").substring(12));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            dbconn mDbconn = new dbconn();
            ResultSet res1 = mDbconn.statement.executeQuery("SELECT * FROM bank WHERE pass = '"+pass+"';");
            int bal = 0;
            while(res1.next()){
                label3.setText(label3.getText() + "<html>"+res1.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+res1.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+res1.getString("amount")+"<br><br><html>");
                if(res1.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(res1.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(res1.getString("amount"));
                }
            }

            label2.setText("Your total balance is Rs. "+bal);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("System",Font.BOLD,14));
        exitButton.setBounds(210,340,150,40);
        exitButton.addActionListener(this);
        add(exitButton);

        setLayout(null);
        getContentPane().setBackground(new Color(225,200,255));
        setSize(600,450);
        setLocation(250,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new miniStat("");
    }

}

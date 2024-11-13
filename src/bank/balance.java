package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class balance extends JFrame implements ActionListener{

    JLabel label2;

    JButton backButton;

    String pass;

    balance(String pass){
        super("Balance Enquiry");

        this.pass = pass;

        JLabel label1 = new JLabel("Your current balace is Rs. ");
        label1.setBounds(100,30,400,30);
        label1.setFont(new Font("System",Font.BOLD,16));
        add(label1);

        label2 = new JLabel();
        label2.setBounds(110,70,400,30);
        label2.setFont(new Font("System",Font.BOLD,16));
        add(label2);

        backButton = new JButton("Back");
        backButton.setFont(new Font("System",Font.BOLD,14));
        backButton.setBounds(220,320,150,40);
        backButton.addActionListener(this);
        add(backButton);

        int bal = 0;
        try{
            dbconn bDbconn = new dbconn();
            ResultSet res = bDbconn.statement.executeQuery("SELECT * FROM bank WHERE pass = '"+pass+"';");
            while(res.next()){
                if(res.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(res.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(res.getString("amount"));
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        label2.setText(""+bal);

        setLayout(null);
        getContentPane().setBackground(new Color(215,255,210));
        setSize(600,450);
        setLocation(450,170);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            setVisible(false);
            new transactions(pass);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new balance("");
    }

}

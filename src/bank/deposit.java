package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class deposit extends JFrame implements ActionListener{

    JTextField textField;

    JButton depositButton, backButton;

    String pass;

    deposit(String pass){
        super("Deposit");

        this.pass = pass;

        JLabel label1 = new JLabel("Enter the amount you want to DEPOSIT :");
        label1.setBounds(100,130,400,30);
        label1.setFont(new Font("System",Font.BOLD,16));
        add(label1);

        textField = new JTextField();
        textField.setFont(new Font("System",Font.BOLD,14));
        textField.setBounds(100,180,370,30);
        add(textField);

        depositButton = new JButton("DEPOSIT");
        depositButton.setFont(new Font("System",Font.BOLD,14));
        depositButton.setBounds(120,300,150,40);
        depositButton.addActionListener(this);
        add(depositButton);

        backButton = new JButton("Back");
        backButton.setFont(new Font("System",Font.BOLD,14));
        backButton.setBounds(300,300,150,40);
        backButton.addActionListener(this);
        add(backButton);

        setLayout(null);
        getContentPane().setBackground(new Color(215,255,210));
        setSize(600,450);
        setLocation(450,170);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amt = textField.getText();
            Date date = new Date();
            if(e.getSource()==depositButton){
                if(amt.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill the amount");
                }
                else{
                    dbconn dpDbconn = new dbconn();
                    dpDbconn.statement.executeUpdate("INSERT INTO bank VALUES('"+pass+"','"+date+"','Deposit','"+amt+"');");
                    JOptionPane.showMessageDialog(null, "Rs. "+amt+" deposit successful");
                    setVisible(false);
                    new transactions(pass);
                }
            } 
            else if(e.getSource()==backButton){
                setVisible(false);
                new transactions(pass);
            }     
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new deposit("");
    }

}

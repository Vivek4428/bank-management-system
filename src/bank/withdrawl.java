package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener{

    JTextField textField;

    JButton withdrawButton, backButton;

    String pass;

    withdrawl(String pass){
        super("Withdrawl");

        this.pass = pass;

        JLabel label1 = new JLabel("Enter the amount you want to WITHDRAW :");
        label1.setBounds(100,130,400,30);
        label1.setFont(new Font("System",Font.BOLD,16));
        add(label1);

        JLabel label2 = new JLabel("The maximum amount is Rs. 10,000.");
        label2.setBounds(100,160,400,30);
        label2.setFont(new Font("System",Font.BOLD,16));
        add(label2);

        textField = new JTextField();
        textField.setFont(new Font("System",Font.BOLD,14));
        textField.setBounds(100,210,370,30);
        add(textField);

        withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setFont(new Font("System",Font.BOLD,14));
        withdrawButton.setBounds(120,300,150,40);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

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
            if(e.getSource()==withdrawButton){
                String amt = textField.getText();
                Date date = new Date();
                if(textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                }
                else{
                    dbconn wDbconn = new dbconn();
                    ResultSet res = wDbconn.statement.executeQuery("SELECT * FROM bank WHERE pass = '"+pass+"';");
                    int bal = 0;
                    while(res.next()){
                        if(res.getString("type").equals("Deposit")){
                            bal += Integer.parseInt(res.getString("amount"));
                        }
                        else{
                            bal -= Integer.parseInt(res.getString("amount"));
                        }
                    }
                    if(bal < Integer.parseInt(amt)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    wDbconn.statement.executeUpdate("INSERT INTO bank VALUES ('"+pass+"','"+date+"','Withdrawl','"+amt+"');");
                    JOptionPane.showMessageDialog(null, "Rs. "+amt+" debit successful");
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
        new withdrawl("");
    }

}

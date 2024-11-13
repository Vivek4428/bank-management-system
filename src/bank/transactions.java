package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class transactions extends JFrame implements ActionListener{

    JButton button1, button2, button3, button4, button5, button6, button7;

    String pass;
    
    transactions(String pass){
        super("Transactions");

        this.pass = pass;

        JLabel label1 = new JLabel("Please select your transaction");
        label1.setBounds(150,90,450,30);
        label1.setFont(new Font("System",Font.BOLD,18));
        add(label1);

        button1 = new JButton("Deposit");
        button1.setFont(new Font("System",Font.BOLD,14));
        button1.setBounds(120,150,150,40);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Cash Withdrawl");
        button2.setFont(new Font("System",Font.BOLD,14));
        button2.setBounds(330,150,150,40);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Fast Cash");
        button3.setFont(new Font("System",Font.BOLD,14));
        button3.setBounds(120,200,150,40);
        button3.addActionListener(this);
        add(button3);

        button4 = new JButton("Mini Statement");
        button4.setFont(new Font("System",Font.BOLD,14));
        button4.setBounds(330,200,150,40);
        button4.addActionListener(this);
        add(button4);

        button5 = new JButton("Password Change");
        button5.setFont(new Font("System",Font.BOLD,12));
        button5.setBounds(120,250,150,40);
        button5.addActionListener(this);
        add(button5);

        button6 = new JButton("Balance Enquiry");
        button6.setFont(new Font("System",Font.BOLD,14));
        button6.setBounds(330,250,150,40);
        button6.addActionListener(this);
        add(button6);

        button7 = new JButton("EXIT");
        button7.setFont(new Font("System",Font.BOLD,14));
        button7.setBounds(250,320,100,40);
        button7.addActionListener(this);
        add(button7);

        setLayout(null);
        getContentPane().setBackground(new Color(250,215,200));
        setSize(600,450);
        setLocation(450,170);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==button1){
                new deposit(pass);
                setVisible(false);
            }
            else if(e.getSource()==button2){
                new withdrawl(pass);
                setVisible(false);
            }
            else if(e.getSource()==button3){
                new fastCash(pass);
                setVisible(false);
            }
            else if(e.getSource()==button4){
                new miniStat(pass);
            }
            else if(e.getSource()==button5){
                new passchange(pass);
                setVisible(false);
            }
            else if(e.getSource()==button6){
                new balance(pass);
                setVisible(false);
            }
            else if(e.getSource()==button7){
                System.exit(0);
            }
            
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new transactions("");
    }
}

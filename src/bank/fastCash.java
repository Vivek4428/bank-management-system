package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener{

    JButton button1, button2, button3, button4, button5, button6, button7;

    String pass;

    fastCash(String pass){
        super("Fast Cash");

        this.pass = pass;

        JLabel label1 = new JLabel("Please select your amount");
        label1.setBounds(150,90,450,30);
        label1.setFont(new Font("System",Font.BOLD,18));
        add(label1);

        button1 = new JButton("Rs. 100");
        button1.setFont(new Font("System",Font.BOLD,14));
        button1.setBounds(120,150,150,40);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Rs. 500");
        button2.setFont(new Font("System",Font.BOLD,14));
        button2.setBounds(330,150,150,40);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Rs. 1000");
        button3.setFont(new Font("System",Font.BOLD,14));
        button3.setBounds(120,200,150,40);
        button3.addActionListener(this);
        add(button3);

        button4 = new JButton("Rs. 2000");
        button4.setFont(new Font("System",Font.BOLD,14));
        button4.setBounds(330,200,150,40);
        button4.addActionListener(this);
        add(button4);

        button5 = new JButton("Rs. 5000");
        button5.setFont(new Font("System",Font.BOLD,14));
        button5.setBounds(120,250,150,40);
        button5.addActionListener(this);
        add(button5);

        button6 = new JButton("Rs. 10000");
        button6.setFont(new Font("System",Font.BOLD,14));
        button6.setBounds(330,250,150,40);
        button6.addActionListener(this);
        add(button6);

        button7 = new JButton("BACK");
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
            if(e.getSource()==button7){
                setVisible(false);
                new transactions(pass);
            }
            else{
                String amt = ((JButton)e.getSource()).getText().substring(4);
                dbconn fDbconn = new dbconn();
                Date date = new Date();
                ResultSet res = fDbconn.statement.executeQuery("SELECT * FROM bank WHERE pass = '"+pass+"';");
                int bal = 0;
                while(res.next()){
                    if(res.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(res.getString("amount"));
                    }
                    else{
                        bal -= Integer.parseInt(res.getString("amount"));
                    }
                }
                
                if(e.getSource()!= button7 && bal < Integer.parseInt(amt)){
                    JOptionPane.showMessageDialog(null, "Insufficient Blanace");
                    return;
                }

                fDbconn.statement.executeUpdate("INSERT INTO bank VALUES('"+pass+"','"+date+"','Withdrawl','"+amt+"');");
                JOptionPane.showMessageDialog(null, "Rs. "+amt+" debit successful");
            }
            setVisible(false);
            new transactions(pass);
            
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new fastCash("");
    }

}

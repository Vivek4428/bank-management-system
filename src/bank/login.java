package bank;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class login extends JFrame implements ActionListener{

    JLabel label1, label2, label3;

    JTextField textField1;

    JPasswordField passwordField1;
    
    JButton button1, button2, button3;

    login(){
        super("My Bank");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        label1 = new JLabel("WELCOME TO MY BANK");
        label1.setFont(new Font("AvantGarde",Font.BOLD,35));
        label1.setBounds(200, 125, 450, 40);
        add(label1);

        label2 = new JLabel("Username:");
        label2.setFont(new Font("Ralway", Font.BOLD,26));
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        textField1 = new JTextField(15);
        textField1.setBounds(325, 190, 230, 30);
        textField1.setFont(new Font("Arial",Font.ITALIC,15));
        add(textField1);

        label3 = new JLabel("Password:");
        label3.setFont(new Font("Ralway", Font.BOLD,26));
        label3.setBounds(150, 250, 375, 30);
        add(label3);

        passwordField1 = new JPasswordField(15);
        passwordField1.setBounds(325,250,230,30);
        passwordField1.setFont(new Font("Arial", Font.ITALIC,15));
        add(passwordField1);

        button1 = new JButton("LOG IN");
        button1.setFont(new Font("Arial",Font.PLAIN,15));
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.PLAIN,15));
        button2.setBounds(450,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.PLAIN,15));
        button3.setBounds(320,350,200,30);
        button3.addActionListener(this);
        add(button3);

        setLayout(null);
        setSize(850, 480);
        setVisible(true);
        setLocation(400, 200);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == button1){
                dbconn lDbconn = new dbconn();
                String userName = textField1.getText();
                String pass = passwordField1.getText();
                String q = "SELECT  * FROM user_pass WHERE user_name = '"+userName+"' AND pass = '"+pass+"';";
                ResultSet res = lDbconn.statement.executeQuery(q);
                if(res.next()){
                    setVisible(false);
                    new transactions(pass);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid USERNAME or PASSWORD");
                }
            }
            else if(e.getSource() == button2){
                textField1.setText("");
                passwordField1.setText("");
            }
            else if(e.getSource() == button3){
                new signup();
                setVisible(false);
            }
        }
        catch(Exception x){
            x.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new login();
    }
}

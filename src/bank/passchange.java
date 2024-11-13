package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class passchange extends JFrame implements ActionListener{

    JButton changeButton, backButton;

    JPasswordField passField1, passField2;

    String pass;

    passchange(String pass){
        super("Password Change");

        this.pass = pass;

        JLabel label1 = new JLabel("Enter your new password :");
        label1.setBounds(100,100,400,30);
        label1.setFont(new Font("System",Font.BOLD,16));
        add(label1);

        passField1 = new JPasswordField();
        passField1.setFont(new Font("System",Font.BOLD,14));
        passField1.setBounds(100,130,370,30);
        add(passField1);

        JLabel label2 = new JLabel("Re-enter your new password :");
        label2.setBounds(100,170,400,30);
        label2.setFont(new Font("System",Font.BOLD,16));
        add(label2);

        passField2 = new JPasswordField();
        passField2.setFont(new Font("System",Font.BOLD,14));
        passField2.setBounds(100,200,370,30);
        add(passField2);


        changeButton = new JButton("CHANGE");
        changeButton.setFont(new Font("System",Font.BOLD,14));
        changeButton.setBounds(120,300,150,40);
        changeButton.addActionListener(this);
        add(changeButton);

        backButton = new JButton("Back");
        backButton.setFont(new Font("System",Font.BOLD,14));
        backButton.setBounds(300,300,150,40);
        backButton.addActionListener(this);
        add(backButton);

        setLayout(null);
        getContentPane().setBackground(new Color(205,255,250));
        setSize(600,450);
        setLocation(450,170);
        setVisible(true);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pass1 = passField1.getText();
            String pass2 = passField2.getText();

            if(!pass1.equals(pass2)){
                JOptionPane.showMessageDialog(null, "Entered password does not match");
                return;
            }

            if(e.getSource()==changeButton){
                if(pass1.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter new password");
                    return;
                }
                if(pass2.equals("")){
                    JOptionPane.showMessageDialog(null, "Re-enter new password");
                    return;
                }

                dbconn pcDbconn = new dbconn();
                pcDbconn.statement.executeUpdate("UPDATE user_pass SET pass = '"+pass1+"' WHERE pass = '"+pass+"';");

                JOptionPane.showMessageDialog(null, "Password changed successfully");
                setVisible(false);
                new transactions(pass);
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
        new passchange("");
    }

}

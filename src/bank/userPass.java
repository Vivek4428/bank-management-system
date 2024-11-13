package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class userPass extends JFrame implements ActionListener{

    JTextField userName, passwordField, passwordField1;
    
    JButton submit, cancel;

    String formNo, cardNo;

    userPass(String str, String cardNo){
        super("LOGIN DETALILS");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(80, 10, 100, 100);
        add(image);

        this.formNo = str;
        this.cardNo = cardNo;

        JLabel label1 = new JLabel("Page: 4");
        label1.setBounds(250,30,200,30);
        label1.setFont(new Font("Raleway",Font.BOLD,20));
        add(label1);

        JLabel label6 = new JLabel("Login Details");
        label6.setBounds(220,70,400,40);
        label6.setFont(new Font("Raleway",Font.BOLD,25));
        add(label6);

        JLabel label5 = new JLabel("Form No: ");
        label5.setBounds(380,30,100,20);
        label5.setFont(new Font("Raleway",Font.BOLD,14));
        add(label5);

        JLabel label2 = new JLabel(formNo);
        label2.setBounds(450,30,100,20);
        label2.setFont(new Font("Raleway",Font.BOLD,13));
        add(label2);

        JLabel label3 = new JLabel("Unsername:");
        label3.setBounds(80,190,120,30);
        label3.setFont(new Font("Raleway",Font.BOLD,18));
        add(label3);

        userName = new JTextField();
        userName.setFont(new Font("Raleway",Font.BOLD,14));
        userName.setBounds(270,190,250,30);
        add(userName);

        JLabel label4 = new JLabel("Password:");
        label4.setFont(new Font("Ralway", Font.BOLD,18));
        label4.setBounds(80, 250, 100, 30);
        add(label4);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(270,250,250,30);
        passwordField.setFont(new Font("Arial", Font.ITALIC,14));
        add(passwordField);

        JLabel label7 = new JLabel("Re-enter Password:");
        label7.setFont(new Font("Ralway", Font.BOLD,18));
        label7.setBounds(80, 300, 250, 30);
        add(label7);

        passwordField1 = new JPasswordField(15);
        passwordField1.setBounds(270,300,250,30);
        passwordField1.setFont(new Font("Arial", Font.ITALIC,14));
        add(passwordField1);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(100,400,150,40);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(320,400,150,40);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        getContentPane().setBackground(new Color(215,252,252));
        setSize(600,550);
        setLocation(360,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user_name = userName.getText();
        String pass = passwordField.getText();
        String pass1 = passwordField1.getText();
        try {
            if(e.getSource()==submit){
                if(user_name.equals("") || pass.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all fields");
                }
                else if(!pass1.equals(pass)){
                    JOptionPane.showMessageDialog(null, "Entered password does not match");
                    return;
                }
                else{
                    dbconn upDbconn = new dbconn();
                    String q = "INSERT INTO user_pass VALUES('"+formNo+"','"+user_name+"','"+pass+"','"+cardNo+"');";
                    upDbconn.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Password changed sucessfully");
                    new deposit(pass);
                    setVisible(false);
                }
            }
            else if(e.getSource()==cancel){
                System.exit(0);
            }
            
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new userPass("","");
    }
}

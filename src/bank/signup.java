package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class signup extends JFrame implements ActionListener{
    Random ran = new Random();
    long num = (ran.nextLong()%9000L)+1000L;
    String str = " "+Math.abs(num);

    JTextField textName, textFname, textMail, textAdd, textCity, textPin, textState;

    JDateChooser dateChooser;
    
    JRadioButton genButton1, genButton2, genButton3, mButton1, mButton2, mButton3;
    
    JButton next;

    signup(){
        super("Application Form");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO:"+str);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,35));
        add(label1);

        JLabel label2 = new JLabel("Page: 1");
        label2.setBounds(350,60,600,30);
        label2.setFont(new Font("Raleway",Font.BOLD,20)); 
        add(label2);

        JLabel label3 = new JLabel("Personal Information");
        label3.setBounds(290,80,600,40);
        label3.setFont(new Font("Raleway",Font.BOLD,20));
        add(label3);

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(100,180,100,30);
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,180,400,30);
        add(textName);

        JLabel labelFname = new JLabel("Father's Name:");
        labelFname.setBounds(100,230,400,30);
        labelFname.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelFname);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD,14));
        textFname.setBounds(300,230,400,30);
        add(textFname);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(100,280,400,30);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300, 280, 400, 30);
        add(dateChooser);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setFont(new Font("Raleway",Font.BOLD,20));
        labelGender.setBounds(100, 330, 400, 30);
        add(labelGender);

        genButton1 = new JRadioButton("Male");
        genButton1.setFont(new Font("Raleway",Font.BOLD,14));
        genButton1.setBackground(new Color(222,255,228));
        genButton1.setBounds(300,330,60,30);
        add(genButton1);

        genButton2 = new JRadioButton("Female");
        genButton2.setFont(new Font("Raleway",Font.BOLD,14));
        genButton2.setBackground(new Color(222,255,228));
        genButton2.setBounds(400,330,90,30);
        add(genButton2);

        genButton3 = new JRadioButton("Others");
        genButton3.setFont(new Font("Raleway",Font.BOLD,14));
        genButton3.setBackground(new Color(222,255,228));
        genButton3.setBounds(500,330,90,30);
        add(genButton3);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(genButton1);
        buttonGroup.add(genButton2);
        buttonGroup.add(genButton3);

        JLabel labelMail = new JLabel("Email:");
        labelMail.setBounds(100, 380, 90, 30);
        labelMail.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelMail);

        textMail = new JTextField();
        textMail.setFont(new Font("System",Font.BOLD,14));
        textMail.setBounds(300,380,400,30);
        add(textMail);

        JLabel labelMs = new JLabel("Marital Status:");
        labelMs.setBounds(100, 430, 200, 30);
        labelMs.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelMs);

        mButton1 = new JRadioButton("Married");
        mButton1.setFont(new Font("Raleway",Font.BOLD,14));
        mButton1.setBackground(new Color(222,255,228));
        mButton1.setBounds(300,430,90,30);
        add(mButton1);

        mButton2 = new JRadioButton("Unmarried");
        mButton2.setFont(new Font("Raleway",Font.BOLD,14));
        mButton2.setBackground(new Color(222,255,228));
        mButton2.setBounds(400,430,100,30);
        add(mButton2);

        mButton3 = new JRadioButton("Others");
        mButton3.setFont(new Font("Raleway",Font.BOLD,14));
        mButton3.setBackground(new Color(222,255,228));
        mButton3.setBounds(510,430,90,30);
        add(mButton3);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(mButton1);
        buttonGroup2.add(mButton2);
        buttonGroup2.add(mButton3);

        JLabel labelAdd = new JLabel("Address:");
        labelAdd.setBounds(100, 480, 200, 30);
        labelAdd.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD,14));
        textAdd.setBounds(300,480,400,30);
        add(textAdd);

        JLabel labelCity = new JLabel("City:");
        labelCity.setBounds(100, 530, 60, 30);
        labelCity.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        textCity.setBounds(300,530,400,30);
        add(textCity);

        JLabel labelPin = new JLabel("Pin Code:");
        labelPin.setBounds(100, 580, 200, 30);
        labelPin.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway",Font.BOLD,14));
        textPin.setBounds(300,580,400,30);
        add(textPin);

        JLabel labelState = new JLabel("State:");
        labelState.setBounds(100, 630, 60, 30);
        labelState.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD,14));
        textState.setBounds(300,630,400,30);
        add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(280,690,200,40);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,780);
        setLocation(360,20);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = str;
        String name = textName.getText();
        String fname = textFname.getText();
        String dobString = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if(genButton1.isSelected()){
            gender = "Male";
        }
        else if(genButton2.isSelected()){
            gender = "Female";
        }
        else if(genButton3.isSelected()){
            gender = "Others";
        }

        String email = textMail.getText();

        String mStatus = null;
        if(mButton1.isSelected()){
            mStatus = "Married";
        }
        else if(mButton2.isSelected()){
            mStatus = "Unmarried";
        }
        else if(mButton3.isSelected()){
            mStatus = "Others";
        }

        String addr = textAdd.getText();
        String city = textCity.getText();
        String pinCode = textPin.getText();
        String state = textState.getText();

        try {
            if(textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all fields");
            }
            else{
                dbconn conDbconn = new dbconn();
                String q = "INSERT INTO signupData VALUES('"+formNo+"','"+name+"','"+fname+"','"+dobString+"','"+gender+"','"+email+"','"+mStatus+"','"+addr+"','"+city+"','"+pinCode+"','"+state+"');";
                conDbconn.statement.executeUpdate(q);
                new signupPg2(formNo);
                setVisible(false);
            }
            
        } catch (Exception x) {
            x.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        new signup();
    }

}

package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signupPg2 extends JFrame implements ActionListener{

    @SuppressWarnings("rawtypes")
    JComboBox comboBox1,comboBox2,comboBox3,comboBox4,comboBox5;

    
    JTextField textPan,textAadhar;
    
    JRadioButton scButton1, scButton2, eaButton1, eaButton2;
    
    JButton next;

    String formNo;

    signupPg2(String str){
        super("Application Form");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 10, 100, 100);
        add(image);

        this.formNo = str;

        JLabel label1 = new JLabel("Page: 2");
        label1.setBounds(350,40,600,30);
        label1.setFont(new Font("Raleway",Font.BOLD,20));
        add(label1);

        JLabel label2 = new JLabel("Additional Details");
        label2.setBounds(300,70,600,40);
        label2.setFont(new Font("Raleway",Font.BOLD,25));
        add(label2);

        JLabel label3 = new JLabel("Religion:");
        label3.setBounds(100,140,200,30);
        label3.setFont(new Font("Raleway",Font.BOLD,20));
        add(label3);

        String [] religion = {"Hindu","Muslim","Sikh","Christian","Other"};
        comboBox1 = new JComboBox<>(religion);
        comboBox1.setBackground(new Color(252,208,76));
        comboBox1.setFont(new Font("Raleway",Font.ITALIC,15));
        comboBox1.setBounds(350,140,300,30);
        add(comboBox1);

        JLabel label4 = new JLabel("Category:");
        label4.setBounds(100,190,200,30);
        label4.setFont(new Font("Raleway",Font.BOLD,20));
        add(label4);

        String [] category = {"General","OBC","SC","ST","Other"};
        comboBox2 = new JComboBox<>(category);
        comboBox2.setBackground(new Color(252,208,76));
        comboBox2.setFont(new Font("Raleway",Font.ITALIC,15));
        comboBox2.setBounds(350,190,300,30);
        add(comboBox2);

        JLabel label5 = new JLabel("Income:");
        label5.setBounds(100,240,200,30);
        label5.setFont(new Font("Raleway",Font.BOLD,20));
        add(label5);

        String [] income = {"<1,50,000","<2,50,000","<5,00,000","<10,00,000",">10,00,000"};
        comboBox3 = new JComboBox<>(income);
        comboBox3.setBackground(new Color(252,208,76));
        comboBox3.setFont(new Font("Raleway",Font.ITALIC,15));
        comboBox3.setBounds(350,240,300,30);
        add(comboBox3);

        JLabel label6 = new JLabel("Education:");
        label6.setBounds(100,290,200,30);
        label6.setFont(new Font("Raleway",Font.BOLD,20));
        add(label6);

        String [] education = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
        comboBox4 = new JComboBox<>(education);
        comboBox4.setBackground(new Color(252,208,76));
        comboBox4.setFont(new Font("Raleway",Font.ITALIC,15));
        comboBox4.setBounds(350,290,300,30);
        add(comboBox4);

        JLabel label7 = new JLabel("Occupation:");
        label7.setBounds(100,340,200,30);
        label7.setFont(new Font("Raleway",Font.BOLD,20));
        add(label7);

        String [] occupation = {"Salaried","Self-Employed","Business","Student","Retired"};
        comboBox5 = new JComboBox<>(occupation);
        comboBox5.setBackground(new Color(252,208,76));
        comboBox5.setFont(new Font("Raleway",Font.ITALIC,15));
        comboBox5.setBounds(350,340,300,30);
        add(comboBox5);

        JLabel label8 = new JLabel("PAN Number:");
        label8.setBounds(100,390,200,30);
        label8.setFont(new Font("Raleway",Font.BOLD,20));
        add(label8);

        textPan = new JTextField();
        textPan.setBounds(350,390,300,30);
        textPan.setFont(new Font("Raleway",Font.BOLD,20));
        add(textPan);

        JLabel label9 = new JLabel("Aadhar Number:");
        label9.setBounds(100,440,200,30);
        label9.setFont(new Font("Raleway",Font.BOLD,20));
        add(label9);

        textAadhar = new JTextField();
        textAadhar.setBounds(350,440,300,30);
        textAadhar.setFont(new Font("Raleway",Font.BOLD,20));
        add(textAadhar);

        JLabel label10 = new JLabel("Senior Citizen:");
        label10.setBounds(100,490,200,30);
        label10.setFont(new Font("Raleway",Font.BOLD,20));
        add(label10);

        scButton1 = new JRadioButton("Yes");
        scButton1.setBounds(350,490,100,30);
        scButton1.setBackground(new Color(252,208,76));
        scButton1.setFont(new Font("Raleway",Font.BOLD,15));
        add(scButton1);

        scButton2 = new JRadioButton("No");
        scButton2.setBounds(500,490,100,30);
        scButton2.setBackground(new Color(252,208,76));
        scButton2.setFont(new Font("Raleway",Font.BOLD,15));
        add(scButton2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(scButton1);
        buttonGroup.add(scButton2);

        JLabel label11 = new JLabel("Exsiting Account:");
        label11.setBounds(100,540,200,30);
        label11.setFont(new Font("Raleway",Font.BOLD,20));
        add(label11);

        eaButton1 = new JRadioButton("Yes");
        eaButton1.setBounds(350,540,100,30);
        eaButton1.setBackground(new Color(252,208,76));
        eaButton1.setFont(new Font("Raleway",Font.BOLD,15));
        add(eaButton1);

        eaButton2 = new JRadioButton("No");
        eaButton2.setBounds(500,540,100,30);
        eaButton2.setBackground(new Color(252,208,76));
        eaButton2.setFont(new Font("Raleway",Font.BOLD,15));
        add(eaButton2);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(eaButton1);
        buttonGroup2.add(eaButton2);

        JLabel label12 = new JLabel("Form No: ");
        label12.setBounds(630,30,100,30);
        label12.setFont(new Font("Raleway",Font.BOLD,14));
        add(label12);

        JLabel label13 = new JLabel(formNo);
        label13.setBounds(700,30,100,30);
        label13.setFont(new Font("Raleway",Font.BOLD,14));
        add(label13);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(280,610,200,40);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        getContentPane().setBackground(new Color(252,208,76));
        setSize(850,750);
        setLocation(360,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String) comboBox1.getSelectedItem();
        String category = (String) comboBox2.getSelectedItem();
        String income = (String) comboBox3.getSelectedItem();
        String education = (String) comboBox4.getSelectedItem();
        String occupation = (String) comboBox5.getSelectedItem();

        String panNo = textPan.getText();
        String aadharNo = textAadhar.getText();

        String scitizen = null;
        if(scButton1.isSelected()){
            scitizen = "Yes";
        }
        else if(scButton2.isSelected()){
            scitizen = "No";
        }

        String existAcc = null;
        if(eaButton1.isSelected()){
            existAcc = "Yes";
        }
        else if(eaButton2.isSelected()){
            existAcc = "No";
        }

        try {
            if(textPan.getText().equals("") || textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all dields");
            }
            else{
                dbconn cDbconn = new dbconn();
                String q = "INSERT INTO signup_two VALUES('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+panNo+"','"+aadharNo+"','"+scitizen+"','"+existAcc+"');";
                cDbconn.statement.executeUpdate(q);
                new signupPg3(formNo);
                setVisible(false);
            }
            
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new signupPg2("");
    }

}

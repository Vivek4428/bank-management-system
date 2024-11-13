package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class signupPg3 extends JFrame implements ActionListener{

    JRadioButton tButton1, tButton2, tButton3, tButton4;

    
    JCheckBox cButton1, cButton2, cButton3, cButton4, cButton5, cButton6;
    
    JButton next;

    String formNo;

    signupPg3(String str){
        super("ACCOUNT DETALILS");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 10, 100, 100);
        add(image);

        this.formNo = str;

        JLabel label1 = new JLabel("Page: 3");
        label1.setBounds(350,30,600,30);
        label1.setFont(new Font("Raleway",Font.BOLD,25));
        add(label1);

        JLabel label2 = new JLabel("Account Details:");
        label2.setBounds(300,70,600,30);
        label2.setFont(new Font("Raleway",Font.BOLD,30));
        add(label2);

        JLabel label3 = new JLabel("Account Type:");
        label3.setBounds(100,140,200,30);
        label3.setFont(new Font("Raleway",Font.BOLD,20));
        add(label3);

        tButton1 = new JRadioButton("Savings Account");
        tButton1.setBounds(110,180,160,30);
        tButton1.setBackground(new Color(215,252,252));
        tButton1.setFont(new Font("Raleway",Font.BOLD,16));
        add(tButton1);

        tButton2 = new JRadioButton("Current Account");
        tButton2.setBounds(350,180,150,30);
        tButton2.setBackground(new Color(215,252,252));
        tButton2.setFont(new Font("Raleway",Font.BOLD,16));
        add(tButton2);

        tButton3 = new JRadioButton("Fixed Deposit");
        tButton3.setBounds(110,230,160,30);
        tButton3.setBackground(new Color(215,252,252));
        tButton3.setFont(new Font("Raleway",Font.BOLD,16));
        add(tButton3);

        tButton4 = new JRadioButton("Recurring Deposit Account");
        tButton4.setBounds(350,230,250,30);
        tButton4.setBackground(new Color(215,252,252));
        tButton4.setFont(new Font("Raleway",Font.BOLD,16));
        add(tButton4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(tButton1);
        buttonGroup.add(tButton2);
        buttonGroup.add(tButton3);
        buttonGroup.add(tButton4);

        JLabel label4 = new JLabel("Card Number:");
        label4.setBounds(100,300,200,30);
        label4.setFont(new Font("Raleway",Font.BOLD,18));
        add(label4);

        JLabel label5 = new JLabel("(Your 16-digit Card Number)");
        label5.setBounds(100,320,300,30);
        label5.setFont(new Font("Raleway",Font.BOLD,12));
        add(label5);

        JLabel label6 = new JLabel("XXXX-XXXX-XXXX-1234");
        label6.setBounds(350,300,400,30);
        label6.setFont(new Font("Raleway",Font.BOLD,16));
        add(label6);

        JLabel label7 = new JLabel("(It would appear on your ATM card / Cheque Book and Statements)");
        label7.setBounds(350,320,400,30);
        label7.setFont(new Font("Raleway",Font.BOLD,12));
        add(label7);

        JLabel label8 = new JLabel("PIN Number:");
        label8.setBounds(100,360,200,30);
        label8.setFont(new Font("Raleway",Font.BOLD,18));
        add(label8);

        JLabel label9 = new JLabel("XXX");
        label9.setBounds(350,360,100,30);
        label9.setFont(new Font("Raleway",Font.BOLD,18));
        add(label9);

        JLabel label10 = new JLabel("(Your 3-digit PIN Number)");
        label10.setBounds(100,380,300,30);
        label10.setFont(new Font("Raleway",Font.BOLD,12));
        add(label10);

        JLabel label11 = new JLabel("Services Required:");
        label11.setBounds(100,420,200,30);
        label11.setFont(new Font("Raleway",Font.BOLD,18));
        add(label11);

        cButton1 = new JCheckBox("ATM Card");
        cButton1.setBounds(110,450,200,30);
        cButton1.setBackground(new Color(215,252,252));
        cButton1.setFont(new Font("Raleway",Font.BOLD,16));
        add(cButton1);

        cButton2 = new JCheckBox("Cheque Book");
        cButton2.setBounds(350,450,200,30);
        cButton2.setBackground(new Color(215,252,252));
        cButton2.setFont(new Font("Raleway",Font.BOLD,16));
        add(cButton2);

        cButton3 = new JCheckBox("Internet Banking");
        cButton3.setBounds(110,490,200,30);
        cButton3.setBackground(new Color(215,252,252));
        cButton3.setFont(new Font("Raleway",Font.BOLD,16));
        add(cButton3);

        cButton4 = new JCheckBox("Mobile Banking");
        cButton4.setBounds(350,490,200,30);
        cButton4.setBackground(new Color(215,252,252));
        cButton4.setFont(new Font("Raleway",Font.BOLD,16));
        add(cButton4);

        cButton5 = new JCheckBox("E-mail Alerts");
        cButton5.setBounds(110,530,200,30);
        cButton5.setBackground(new Color(215,252,252));
        cButton5.setFont(new Font("Raleway",Font.BOLD,16));
        add(cButton5);

        cButton6 = new JCheckBox("E-Statements");
        cButton6.setBounds(350,530,200,30);
        cButton6.setBackground(new Color(215,252,252));
        cButton6.setFont(new Font("Raleway",Font.BOLD,16));
        add(cButton6);
        
        JCheckBox cButton7 = new JCheckBox("I hereby declare the entered details correct to the best of my knowledge",true);
        cButton7.setBounds(100,590,500,30);
        cButton7.setBackground(new Color(215,252,252));
        cButton7.setFont(new Font("Raleway",Font.BOLD,13));
        add(cButton7);

        JLabel label12 = new JLabel("Form No: ");
        label12.setBounds(610,30,100,30);
        label12.setFont(new Font("Raleway",Font.BOLD,14));
        add(label12);

        JLabel label13 = new JLabel(formNo);
        label13.setBounds(680,30,100,30);
        label13.setFont(new Font("Raleway",Font.BOLD,14));
        add(label13);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(280,640,200,40);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        getContentPane().setBackground(new Color(215,252,252));
        setSize(800,750);
        setLocation(360,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accType = null;
        if(tButton1.isSelected()){
            accType = "Savings Account";
        }
        else if(tButton2.isSelected()){
            accType = "Current Account";
        }
        else if(tButton3.isSelected()){
            accType = "Fixed Deposit";
        }
        else if(tButton4.isSelected()){
            accType = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long firstSev = (ran.nextLong()%9000000L)+4109963000000000L;
        String cardNo = ""+Math.abs(firstSev);
        
        long firstThree = (ran.nextLong()%900L)+100L;
        String pinNo = ""+Math.abs(firstThree);

        String services = "";
        if(cButton1.isSelected()){
            services += "ATM Card";
        }
        else if(cButton2.isSelected()){
            services += "Cheque Book";
        }
        else if(cButton3.isSelected()){
            services += "Internet Banking";
        }
        else if(cButton4.isSelected()){
            services += "Mobile Banking";
        }
        else if(cButton5.isSelected()){
            services += "E-mail Alerts";
        }
        else if(cButton6.isSelected()){
            services += "E-Statements";
        }

        try {
            if(accType.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all fields");
            }
            else{
                dbconn cpDbconn = new dbconn();
                String q = "INSERT INTO signup_three VALUES('"+formNo+"','"+accType+"','"+cardNo+"','"+pinNo+"','"+services+"');";
                cpDbconn.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Card Number: "+cardNo+"\n PIN Number: "+pinNo);
                new userPass(formNo,cardNo);
                setVisible(false);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new signupPg3("");
    }

}

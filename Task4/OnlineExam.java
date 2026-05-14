import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlineExam extends JFrame implements ActionListener {

    CardLayout card;

    JPanel mainPanel;

    JPanel loginPanel;

    JPanel examPanel;

    JLabel title;

    JLabel userLabel;

    JLabel passLabel;

    JTextField userField;

    JPasswordField passField;

    JButton loginButton;

    JButton clearButton;

    JLabel timerLabel;

    JLabel q1;

    JLabel q2;

    JLabel q3;

    JRadioButton q1a1,q1a2,q1a3,q1a4;

    JRadioButton q2a1,q2a2,q2a3,q2a4;

    JRadioButton q3a1,q3a2,q3a3,q3a4;

    ButtonGroup bg1,bg2,bg3;

    JButton submitButton;

    JButton resetButton;

    JButton updateButton;

    JButton logoutButton;

    JButton closeButton;

    JTextArea resultArea;

    JScrollPane scroll;

    Timer timer;

    int time = 60;

    int score = 0;

    String username = "admin";

    String password = "1234";

    OnlineExam() {

        setTitle("Online Examination System");

        card = new CardLayout();

        mainPanel = new JPanel(card);

        createLoginPage();

        createExamPage();

        mainPanel.add(loginPanel,"Login");

        mainPanel.add(examPanel,"Exam");

        add(mainPanel);

        setSize(1000,750);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createLoginPage() {

        loginPanel = new JPanel();

        loginPanel.setLayout(null);

        title = new JLabel("ONLINE EXAM LOGIN");

        title.setBounds(300,50,400,40);

        title.setFont(new Font("Arial",Font.BOLD,28));

        loginPanel.add(title);

        userLabel = new JLabel("Username");

        userLabel.setBounds(250,180,100,30);

        loginPanel.add(userLabel);

        userField = new JTextField();

        userField.setBounds(380,180,180,30);

        loginPanel.add(userField);

        passLabel = new JLabel("Password");

        passLabel.setBounds(250,250,100,30);

        loginPanel.add(passLabel);

        passField = new JPasswordField();

        passField.setBounds(380,250,180,30);

        loginPanel.add(passField);

        loginButton = new JButton("Login");

        loginButton.setBounds(280,350,100,40);

        loginPanel.add(loginButton);

        clearButton = new JButton("Clear");

        clearButton.setBounds(430,350,100,40);

        loginPanel.add(clearButton);

        loginButton.addActionListener(this);

        clearButton.addActionListener(this);
    }

    public void createExamPage() {

        examPanel = new JPanel();

        examPanel.setLayout(null);

        timerLabel = new JLabel("Time Left : 60");

        timerLabel.setBounds(750,30,150,30);

        timerLabel.setFont(new Font("Arial",Font.BOLD,18));

        examPanel.add(timerLabel);

        q1 = new JLabel("1. Java is a ?");

        q1.setBounds(50,80,300,30);

        examPanel.add(q1);

        q1a1 = new JRadioButton("Programming Language");

        q1a1.setBounds(70,120,250,30);

        q1a2 = new JRadioButton("Browser");

        q1a2.setBounds(70,150,250,30);

        q1a3 = new JRadioButton("Game");

        q1a3.setBounds(70,180,250,30);

        q1a4 = new JRadioButton("OS");

        q1a4.setBounds(70,210,250,30);

        examPanel.add(q1a1);

        examPanel.add(q1a2);

        examPanel.add(q1a3);

        examPanel.add(q1a4);

        bg1 = new ButtonGroup();

        bg1.add(q1a1);

        bg1.add(q1a2);

        bg1.add(q1a3);

        bg1.add(q1a4);

        q2 = new JLabel("2. JVM stands for ?");

        q2.setBounds(50,280,300,30);

        examPanel.add(q2);

        q2a1 = new JRadioButton("Java Virtual Machine");

        q2a1.setBounds(70,320,250,30);

        q2a2 = new JRadioButton("Joint Virtual Machine");

        q2a2.setBounds(70,350,250,30);

        q2a3 = new JRadioButton("Java Variable Machine");

        q2a3.setBounds(70,380,250,30);

        q2a4 = new JRadioButton("None");

        q2a4.setBounds(70,410,250,30);

        examPanel.add(q2a1);

        examPanel.add(q2a2);

        examPanel.add(q2a3);

        examPanel.add(q2a4);

        bg2 = new ButtonGroup();

        bg2.add(q2a1);

        bg2.add(q2a2);

        bg2.add(q2a3);

        bg2.add(q2a4);

        q3 = new JLabel("3. Which symbol ends statement?");

        q3.setBounds(50,480,350,30);

        examPanel.add(q3);

        q3a1 = new JRadioButton(";");

        q3a1.setBounds(70,520,250,30);

        q3a2 = new JRadioButton(":");

        q3a2.setBounds(70,550,250,30);

        q3a3 = new JRadioButton("?");

        q3a3.setBounds(70,580,250,30);

        q3a4 = new JRadioButton(",");

        q3a4.setBounds(70,610,250,30);

        examPanel.add(q3a1);

        examPanel.add(q3a2);

        examPanel.add(q3a3);

        examPanel.add(q3a4);

        bg3 = new ButtonGroup();

        bg3.add(q3a1);

        bg3.add(q3a2);

        bg3.add(q3a3);

        bg3.add(q3a4);

        submitButton = new JButton("Submit");

        submitButton.setBounds(450,200,140,40);

        examPanel.add(submitButton);

        resetButton = new JButton("Reset");

        resetButton.setBounds(450,270,140,40);

        examPanel.add(resetButton);

        updateButton = new JButton("Update Profile");

        updateButton.setBounds(450,340,160,40);

        examPanel.add(updateButton);

        logoutButton = new JButton("Logout");

        logoutButton.setBounds(450,410,140,40);

        examPanel.add(logoutButton);

        closeButton = new JButton("Close");

        closeButton.setBounds(450,480,140,40);

        examPanel.add(closeButton);

        resultArea = new JTextArea();

        scroll = new JScrollPane(resultArea);

        scroll.setBounds(650,180,250,250);

        examPanel.add(scroll);

        submitButton.addActionListener(this);

        resetButton.addActionListener(this);

        updateButton.addActionListener(this);

        logoutButton.addActionListener(this);

        closeButton.addActionListener(this);

        timer = new Timer(1000,new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                time--;

                timerLabel.setText("Time Left : " + time);

                if(time == 0) {

                    timer.stop();

                    JOptionPane.showMessageDialog(null,
                            "Time Up Auto Submitted");

                    checkAnswers();
                }
            }
        });
    }

    public void checkAnswers() {

        score = 0;

        resultArea.setText("");

        if(q1a1.isSelected()) {

            score++;

            resultArea.append("Q1 Correct\n");
        }

        else {

            resultArea.append("Q1 Wrong\n");
        }

        if(q2a1.isSelected()) {

            score++;

            resultArea.append("Q2 Correct\n");
        }

        else {

            resultArea.append("Q2 Wrong\n");
        }

        if(q3a1.isSelected()) {

            score++;

            resultArea.append("Q3 Correct\n");
        }

        else {

            resultArea.append("Q3 Wrong\n");
        }

        resultArea.append("\nFinal Score = " + score + "/3");
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == loginButton) {

            String u = userField.getText();

            String p = passField.getText();

            if(u.equals(username) && p.equals(password)) {

                JOptionPane.showMessageDialog(this,
                        "Login Successful");

                card.show(mainPanel,"Exam");

                timer.start();
            }

            else {

                JOptionPane.showMessageDialog(this,
                        "Invalid Login");
            }
        }

        if(e.getSource() == clearButton) {

            userField.setText("");

            passField.setText("");
        }

        if(e.getSource() == submitButton) {

            timer.stop();

            checkAnswers();

            JOptionPane.showMessageDialog(this,
                    "Exam Submitted");
        }

        if(e.getSource() == resetButton) {

            bg1.clearSelection();

            bg2.clearSelection();

            bg3.clearSelection();

            resultArea.setText("");

            JOptionPane.showMessageDialog(this,
                    "Answers Reset");
        }

        if(e.getSource() == updateButton) {

            String newUser = JOptionPane.showInputDialog(
                    "Enter New Username");

            String newPass = JOptionPane.showInputDialog(
                    "Enter New Password");

            username = newUser;

            password = newPass;

            JOptionPane.showMessageDialog(this,
                    "Profile Updated");
        }

        if(e.getSource() == logoutButton) {

            timer.stop();

            JOptionPane.showMessageDialog(this,
                    "Logged Out");

            card.show(mainPanel,"Login");
        }

        if(e.getSource() == closeButton) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new OnlineExam();
    }
}

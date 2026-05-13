import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ATMGUI implements ActionListener {

    // LOGIN WINDOW
    JFrame loginFrame;
    JTextField userField;
    JPasswordField pinField;
    JButton loginButton;

    // ATM WINDOW
    JFrame atmFrame;
    JTextField amountField;
    JLabel balanceLabel;
    JTextArea historyArea;

    JButton depositButton, withdrawButton, balanceButton, historyButton, resetButton, exitButton;

    double balance = 1000;
    ArrayList<String> history = new ArrayList<>();

    public ATMGUI() {
        showLogin();
    }

    // ================= LOGIN =================
    public void showLogin() {

        loginFrame = new JFrame("ATM Login");
        loginFrame.setSize(350, 250);
        loginFrame.setLayout(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("ATM LOGIN");
        title.setBounds(120, 20, 150, 30);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 70, 100, 25);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(50, 110, 100, 25);

        userField = new JTextField();
        pinField = new JPasswordField();

        userField.setBounds(150, 70, 120, 25);
        pinField.setBounds(150, 110, 120, 25);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(120, 160, 100, 30);
        loginButton.addActionListener(this);

        loginFrame.add(title);
        loginFrame.add(userLabel);
        loginFrame.add(pinLabel);
        loginFrame.add(userField);
        loginFrame.add(pinField);
        loginFrame.add(loginButton);

        loginFrame.setVisible(true);
    }

    // ================= ATM =================
    public void showATM() {

        atmFrame = new JFrame("ATM System");
        atmFrame.setSize(700, 600);
        atmFrame.setLayout(null);
        atmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("ATM MANAGEMENT SYSTEM");
        title.setBounds(200, 20, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 80, 100, 30);

        amountField = new JTextField();
        amountField.setBounds(150, 80, 150, 30);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        balanceButton = new JButton("Balance");
        historyButton = new JButton("History");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");

        depositButton.setBounds(50, 140, 120, 30);
        withdrawButton.setBounds(180, 140, 120, 30);
        balanceButton.setBounds(50, 190, 120, 30);
        historyButton.setBounds(180, 190, 120, 30);
        resetButton.setBounds(50, 240, 120, 30);
        exitButton.setBounds(180, 240, 120, 30);

        balanceLabel = new JLabel("Balance: ₹1000");
        balanceLabel.setBounds(50, 300, 200, 30);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        historyArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(historyArea);
        scroll.setBounds(350, 80, 300, 400);

        atmFrame.add(title);
        atmFrame.add(amountLabel);
        atmFrame.add(amountField);

        atmFrame.add(depositButton);
        atmFrame.add(withdrawButton);
        atmFrame.add(balanceButton);
        atmFrame.add(historyButton);
        atmFrame.add(resetButton);
        atmFrame.add(exitButton);

        atmFrame.add(balanceLabel);
        atmFrame.add(scroll);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        balanceButton.addActionListener(this);
        historyButton.addActionListener(this);
        resetButton.addActionListener(this);
        exitButton.addActionListener(this);

        atmFrame.setVisible(true);
    }

    // ================= ACTION =================
    public void actionPerformed(ActionEvent e) {

        // LOGIN CHECK
        if (e.getSource() == loginButton) {

            String user = userField.getText();
            String pin = new String(pinField.getPassword());

            if (user.equals("admin") && pin.equals("1234")) {

                JOptionPane.showMessageDialog(null, "Login Successful");

                loginFrame.dispose(); // close login
                showATM();            // open ATM

            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or PIN");
            }
        }

        // DEPOSIT
        if (e.getSource() == depositButton) {

            double amt = Double.parseDouble(amountField.getText());
            balance += amt;

            balanceLabel.setText("Balance: ₹" + balance);
            historyArea.append("Deposited: ₹" + amt + "\n");
        }

        // WITHDRAW
        if (e.getSource() == withdrawButton) {

            double amt = Double.parseDouble(amountField.getText());

            if (amt <= balance) {
                balance -= amt;
                historyArea.append("Withdraw: ₹" + amt + "\n");
            } else {
                historyArea.append("Failed Withdraw\n");
            }

            balanceLabel.setText("Balance: ₹" + balance);
        }

        // BALANCE
        if (e.getSource() == balanceButton) {
            JOptionPane.showMessageDialog(atmFrame, "Balance: ₹" + balance);
        }

        // HISTORY
        if (e.getSource() == historyButton) {
            JOptionPane.showMessageDialog(atmFrame, historyArea.getText());
        }

        // RESET
        if (e.getSource() == resetButton) {
            amountField.setText("");
        }

        // EXIT
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        new ATMGUI();
    }
}
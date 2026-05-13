import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class OnlineReservationSystem extends JFrame implements ActionListener {

    CardLayout card;
    JPanel mainPanel;

    // LOGIN
    JTextField userField;
    JPasswordField passField;
    JButton loginBtn;

    // BOOKING
    JTextField nameField, trainNoField, trainNameField, fromField, toField, dateField;
    JButton bookBtn;

    // CONFIRM PAGE
    JLabel detailsLabel;
    JButton cancelBtn, backBtn;

    // CANCEL PAGE
    JTextField pnrField;
    JButton finalCancelBtn;

    // DATA
    String name, trainNo, trainName, from, to, date;
    int pnr;

    public OnlineReservationSystem() {

        setTitle("Online Reservation System");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        card = new CardLayout();
        mainPanel = new JPanel(card);

        // ================= LOGIN =================
        JPanel loginPanel = new JPanel(null);

        JLabel loginTitle = new JLabel("LOGIN");
        loginTitle.setBounds(250, 20, 100, 30);

        JLabel u1 = new JLabel("Username:");
        JLabel p1 = new JLabel("Password:");

        u1.setBounds(150, 80, 100, 25);
        p1.setBounds(150, 120, 100, 25);

        userField = new JTextField();
        passField = new JPasswordField();

        userField.setBounds(250, 80, 150, 25);
        passField.setBounds(250, 120, 150, 25);

        loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(250, 170, 100, 30);
        loginBtn.addActionListener(this);

        loginPanel.add(loginTitle);
        loginPanel.add(u1);
        loginPanel.add(p1);
        loginPanel.add(userField);
        loginPanel.add(passField);
        loginPanel.add(loginBtn);

        // ================= BOOKING =================
        JPanel bookPanel = new JPanel(null);

        JLabel bookTitle = new JLabel("BOOK TICKET");
        bookTitle.setBounds(230, 20, 200, 30);

        JLabel n1 = new JLabel("Name:");
        JLabel n2 = new JLabel("Train No:");
        JLabel n3 = new JLabel("Train Name:");
        JLabel n4 = new JLabel("From:");
        JLabel n5 = new JLabel("To:");
        JLabel n6 = new JLabel("Date:");

        n1.setBounds(150, 70, 100, 25);
        n2.setBounds(150, 100, 100, 25);
        n3.setBounds(150, 130, 100, 25);
        n4.setBounds(150, 160, 100, 25);
        n5.setBounds(150, 190, 100, 25);
        n6.setBounds(150, 220, 100, 25);

        nameField = new JTextField();
        trainNoField = new JTextField();
        trainNameField = new JTextField();
        fromField = new JTextField();
        toField = new JTextField();
        dateField = new JTextField();

        nameField.setBounds(270, 70, 150, 25);
        trainNoField.setBounds(270, 100, 150, 25);
        trainNameField.setBounds(270, 130, 150, 25);
        fromField.setBounds(270, 160, 150, 25);
        toField.setBounds(270, 190, 150, 25);
        dateField.setBounds(270, 220, 150, 25);

        bookBtn = new JButton("BOOK TICKET");
        bookBtn.setBounds(220, 280, 150, 30);
        bookBtn.addActionListener(this);

        bookPanel.add(bookTitle);
        bookPanel.add(n1); bookPanel.add(n2); bookPanel.add(n3);
        bookPanel.add(n4); bookPanel.add(n5); bookPanel.add(n6);

        bookPanel.add(nameField);
        bookPanel.add(trainNoField);
        bookPanel.add(trainNameField);
        bookPanel.add(fromField);
        bookPanel.add(toField);
        bookPanel.add(dateField);
        bookPanel.add(bookBtn);

        // ================= CONFIRMATION =================
        JPanel confirmPanel = new JPanel(null);

        JLabel confTitle = new JLabel("BOOKING CONFIRMATION");
        confTitle.setBounds(200, 20, 300, 30);

        detailsLabel = new JLabel();
        detailsLabel.setBounds(150, 70, 400, 180);

        cancelBtn = new JButton("CANCEL");
        cancelBtn.setBounds(170, 270, 150, 30);

        backBtn = new JButton("BACK");
        backBtn.setBounds(330, 270, 100, 30);

        cancelBtn.addActionListener(this);
        backBtn.addActionListener(this);

        confirmPanel.add(confTitle);
        confirmPanel.add(detailsLabel);
        confirmPanel.add(cancelBtn);
        confirmPanel.add(backBtn);

        // ================= CANCEL PAGE =================
        JPanel cancelPanel = new JPanel(null);

        JLabel cancelTitle = new JLabel("ENTER PNR TO CANCEL");
        cancelTitle.setBounds(200, 20, 250, 30);

        JLabel pnrLabel = new JLabel("PNR:");
        pnrLabel.setBounds(180, 100, 100, 25);

        pnrField = new JTextField();
        pnrField.setBounds(250, 100, 150, 25);

        finalCancelBtn = new JButton("CONFIRM CANCEL");
        finalCancelBtn.setBounds(220, 160, 150, 30);
        finalCancelBtn.addActionListener(this);

        cancelPanel.add(cancelTitle);
        cancelPanel.add(pnrLabel);
        cancelPanel.add(pnrField);
        cancelPanel.add(finalCancelBtn);

        // ADD PANELS
        mainPanel.add(loginPanel, "login");
        mainPanel.add(bookPanel, "book");
        mainPanel.add(confirmPanel, "confirm");
        mainPanel.add(cancelPanel, "cancel");

        add(mainPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // LOGIN
        if (e.getSource() == loginBtn) {
            if (userField.getText().equals("admin")
                    && new String(passField.getPassword()).equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login Success");
                card.show(mainPanel, "book");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login");
            }
        }

        // BOOK
        if (e.getSource() == bookBtn) {

            name = nameField.getText();
            trainNo = trainNoField.getText();
            trainName = trainNameField.getText();
            from = fromField.getText();
            to = toField.getText();
            date = dateField.getText();

            pnr = new Random().nextInt(9000) + 1000;

            detailsLabel.setText(
                    "<html>"
                    + "<b>BOOKED SUCCESSFULLY</b><br><br>"
                    + "Name: " + name + "<br>"
                    + "Train No: " + trainNo + "<br>"
                    + "Train Name: " + trainName + "<br>"
                    + "From: " + from + "<br>"
                    + "To: " + to + "<br>"
                    + "Date: " + date + "<br>"
                    + "<b>PNR: " + pnr + "</b>"
                    + "</html>"
            );

            JOptionPane.showMessageDialog(this, "PNR Generated: " + pnr);

            card.show(mainPanel, "confirm");
        }

        // CANCEL BUTTON → go to cancel page
        if (e.getSource() == cancelBtn) {
            card.show(mainPanel, "cancel");
        }

        // BACK BUTTON → go to book page
        if (e.getSource() == backBtn) {
            card.show(mainPanel, "book");
        }

        // FINAL CANCEL
        if (e.getSource() == finalCancelBtn) {

            try {
                int entered = Integer.parseInt(pnrField.getText());

                if (entered == pnr) {
                    JOptionPane.showMessageDialog(this, "Ticket Cancelled Successfully");

                    name = trainNo = trainName = from = to = date = null;

                    card.show(mainPanel, "login");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid PNR");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid PNR");
            }
        }
    }

    public static void main(String[] args) {
        new OnlineReservationSystem();
    }
}
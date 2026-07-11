package BMS;

import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {

        setLayout(null);

        // ================= HEADER =================

        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBounds(0, 0, 850, 120);
        header.setBackground(new Color(203, 255, 245));
        add(header);

        // Logo
        ImageIcon logoIcon = new ImageIcon(Login.class.getResource("/icons/atm-machine.png"));
        Image logoImg = logoIcon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(logoImg));
        logo.setBounds(35, 15, 90, 90);
        header.add(logo);

        // Main Heading
        JLabel heading = new JLabel("Welcome to Smart ATM Banking");
        heading.setFont(new Font("Raleway", Font.BOLD, 30));
        heading.setForeground(new Color(0, 77, 64));
        heading.setBounds(150, 20, 600, 38);
        header.add(heading);

        // Sub Heading
        JLabel subHeading = new JLabel("Secure • Fast • Convenient Banking Services");
        subHeading.setFont(new Font("Raleway", Font.PLAIN, 16));
        subHeading.setForeground(new Color(70, 70, 70));
        subHeading.setBounds(152, 58, 420, 25);
        header.add(subHeading);

        // ================= LOGIN PANEL =================

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 145, 620, 330);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 2));
        add(panel);

        JLabel loginTitle = new JLabel("Customer Login");
        loginTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        loginTitle.setForeground(new Color(0, 77, 64));
        loginTitle.setBounds(210, 15, 250, 30);
        panel.add(loginTitle);

        // ================= CARD ICON =================

        ImageIcon cardIcon = new ImageIcon(Login.class.getResource("/icons/id-card-no.png"));
        Image cardImg = cardIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        JLabel cardIconLabel = new JLabel(new ImageIcon(cardImg));
        cardIconLabel.setBounds(25, 78, 24, 24);
        panel.add(cardIconLabel);

        JLabel cardNo = new JLabel("Card No :");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNo.setBounds(60, 70, 130, 35);
        panel.add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(200, 70, 350, 38);
        cardTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        cardTextField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
        panel.add(cardTextField);

        // ================= LOCK ICON =================

        ImageIcon lockIcon = new ImageIcon(Login.class.getResource("/icons/icon-lock-2.png"));
        Image lockImg = lockIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        JLabel lockIconLabel = new JLabel(new ImageIcon(lockImg));
        lockIconLabel.setBounds(25, 145, 24, 24);
        panel.add(lockIconLabel);

        JLabel pin = new JLabel("PIN No :");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(60, 137, 130, 35);
        panel.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(200, 137, 350, 38);
        pinTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        pinTextField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
        panel.add(pinTextField);

        // ================= BUTTONS =================

        login = new JButton("SIGN IN");
        login.setBounds(90, 230, 130, 40);
        login.setForeground(Color.BLACK);
        login.setFocusPainted(false);
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.addActionListener(this);
        panel.add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(245, 230, 130, 40);
        clear.setForeground(Color.BLACK);
        clear.setFocusPainted(false);
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.addActionListener(this);
        panel.add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(400, 230, 130, 40);
        signup.setForeground(Color.BLACK);
        signup.setFocusPainted(false);
        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.addActionListener(this);
        panel.add(signup);

        // ================= FRAME =================

        getContentPane().setBackground(Color.WHITE);

        setTitle("Bank Management System");
        setSize(850, 580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == login) {

            String cardnumber = cardTextField.getText().trim();
            String pinnumber = new String(pinTextField.getPassword()).trim();

            if (cardnumber.equals("") || pinnumber.equals("")) {

                JOptionPane.showMessageDialog(null,
                        "Please enter Card Number and PIN");
                return;
            }

            try {

                Conn conn = new Conn();

                String query = "SELECT * FROM login WHERE cardnumber='"
                        + cardnumber + "' AND pin='"
                        + pinnumber + "'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {

                    JOptionPane.showMessageDialog(null,
                            "Login Successful");

                    setVisible(false);

                    new Transactions(pinnumber);

                } else {

                    JOptionPane.showMessageDialog(null,
                            "Invalid Card Number or PIN");

                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null,
                        e.getMessage());

                e.printStackTrace();
            }

        }

        else if (ae.getSource() == clear) {

            cardTextField.setText("");
            pinTextField.setText("");

        }

        else if (ae.getSource() == signup) {

            setVisible(false);
            new SignupOne();

        }
    }
    public static void main(String[] args) {

        new Login();

    }
}
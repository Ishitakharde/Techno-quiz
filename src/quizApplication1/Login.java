package quizApplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton rules, back;
    JTextField tfname;

    Login() {
        getContentPane().setBackground(new Color(245, 248, 255));
        setLayout(null);

        // LEFT IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(50, 50, 500, 400);
        add(image);

        // TITLE
        JLabel heading = new JLabel("Techno Quiz");
        heading.setBounds(700, 60, 400, 50);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 36));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        // SUBTITLE
        JLabel subheading = new JLabel("Test your knowledge in 10 quick questions!");
        subheading.setBounds(700, 110, 400, 20);
        subheading.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subheading.setForeground(Color.GRAY);
        add(subheading);

        // NAME LABEL
        JLabel name = new JLabel("Enter your name");
        name.setBounds(700, 180, 300, 25);
        name.setFont(new Font("Segoe UI", Font.BOLD, 16));
        name.setForeground(new Color(60, 60, 60));
        add(name);

        // TEXT FIELD
        tfname = new JTextField();
        tfname.setBounds(700, 210, 300, 35);
        tfname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tfname.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        add(tfname);

        // RULES BUTTON
        rules = new JButton("View Rules");
        rules.setBounds(700, 280, 140, 35);
        rules.setBackground(new Color(30, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.setFocusPainted(false);
        rules.setFont(new Font("Segoe UI", Font.BOLD, 14));
        rules.addActionListener(this);
        add(rules);

        // BACK BUTTON
        back = new JButton("Exit");
        back.setBounds(860, 280, 140, 35);
        back.setBackground(new Color(220, 53, 69));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setFont(new Font("Segoe UI", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        setSize(1100, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your name");
            } else {
                setVisible(false);
                new Rules(name);
            }
        } else if (ae.getSource() == back) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
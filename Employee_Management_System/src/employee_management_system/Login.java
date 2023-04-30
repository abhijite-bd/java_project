package employee_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel lblusername, lblpassword;
    Font myFont = new Font("serif", Font.PLAIN, 18);
    JTextField tfusername, tfpassword;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        lblusername.setFont(myFont);
        add(lblusername);
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        lblpassword.setFont(myFont);
        add(lblpassword);
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        JButton login = new JButton("Log In");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(myFont);
        login.setFocusable(false);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setTitle("Admin");
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            String query = "select * from login where username = '" + username + "' and password = '" + password + "' ";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new home();

            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or Password");
                setVisible(false);
                new Login();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

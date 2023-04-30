package employee_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cemid;
    JButton delete, back;

    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblemid = new JLabel("Employee Id");
        lblemid.setBounds(40, 50, 100, 30);
        add(lblemid);

        cemid = new Choice();
        cemid.setBounds(170, 50, 100, 30);
        add(cemid);
        try {
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cemid.add(rs.getString("emid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel lblname = new JLabel("Employee Name");
        lblname.setBounds(40, 100, 100, 30);
        add(lblname);
        JLabel lbldname = new JLabel();
        lbldname.setBounds(170, 100, 100, 30);
        add(lbldname);

        JLabel lblphone = new JLabel("Employee Phone");
        lblphone.setBounds(40, 150, 100, 30);
        add(lblphone);
        JLabel lbldphone = new JLabel();
        lbldphone.setBounds(170, 150, 100, 30);
        add(lbldphone);

        JLabel lblemail = new JLabel("Employee Email");
        lblemail.setBounds(40, 200, 100, 30);
        add(lblemail);
        JLabel lbldemail = new JLabel();
        lbldemail.setBounds(170, 200, 100, 30);
        add(lbldemail);

        try {
            Conn c = new Conn();
            String query = "select * from employee where emid='" + cemid.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lbldname.setText(rs.getString("name"));
                lbldemail.setText(rs.getString("email"));
                lbldphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cemid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from employee where emid='" + cemid.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        lbldname.setText(rs.getString("name"));
                        lbldemail.setText(rs.getString("email"));
                        lbldphone.setText(rs.getString("phone"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        delete = new JButton("Delete");
        delete.setFocusable(false);
        delete.setBounds(40, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        back = new JButton("Back");
        back.setFocusable(false);
        back.setBounds(170, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);

        setTitle("Admin");
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from employee where emid= '" + cemid.getSelectedItem() + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Details Deleted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
        }
        new home();
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }

}

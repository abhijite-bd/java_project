package employee_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import com.toedter.calendar.*;

public class AddEmployee extends JFrame implements ActionListener {

    Font myfont = new Font("Raleway", Font.PLAIN, 20);
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JButton addbtn, backbtn;
    JTextField tfname, tffname, tfsalary, tfdeg, tfphone, tfemail, tfnid, tfaddress;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel labelemid, lblemid;

    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        // heading
        JLabel heading = new JLabel("ADD EMPLOYEE DETAIL");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        add(heading);
        // name
        JLabel labelname = new JLabel("Name");
        labelname.setFont(myfont);
        labelname.setBounds(50, 150, 150, 30);
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        // father's name
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setFont(myfont);
        labelfname.setBounds(400, 150, 150, 30);
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        // Date of Birth
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setFont(myfont);
        labeldob.setBounds(50, 200, 150, 30);
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        // Salary
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setFont(myfont);
        labelsalary.setBounds(400, 200, 150, 30);
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        // Address
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setFont(myfont);
        labeladdress.setBounds(50, 250, 150, 30);
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        // Phone
        JLabel labelphone = new JLabel("Phone No");
        labelphone.setFont(myfont);
        labelphone.setBounds(400, 250, 150, 30);
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        // Email
        JLabel labelemail = new JLabel("Email ");
        labelemail.setFont(myfont);
        labelemail.setBounds(50, 300, 150, 30);
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        // Education
        JLabel labeleducation = new JLabel("Education ");
        labeleducation.setFont(myfont);
        labeleducation.setBounds(400, 300, 150, 30);
        add(labeleducation);

        String courses[] = {"BBA", "BSC", "MBA", "BCOM", "BA"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(600, 300, 150, 30);
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);
        // NID
        JLabel labelnid = new JLabel("NID ");
        labelnid.setFont(myfont);
        labelnid.setBounds(50, 350, 150, 30);
        add(labelnid);

        tfnid = new JTextField();
        tfnid.setBounds(200, 350, 150, 30);
        add(tfnid);
        // Employee Id
        JLabel labelemid = new JLabel("Employee Id");
        labelemid.setFont(myfont);
        labelemid.setBounds(400, 350, 150, 30);
        add(labelemid);

        lblemid = new JLabel("" + number);
        lblemid.setBounds(600, 350, 150, 30);
        add(lblemid);

        // Designation
        JLabel labeldeg = new JLabel("Designation");
        labeldeg.setFont(myfont);
        labeldeg.setBounds(50, 400, 150, 30);
        add(labeldeg);

        tfdeg = new JTextField();
        tfdeg.setBounds(200, 400, 150, 30);
        add(tfdeg);
        // Addbutton
        addbtn = new JButton("Add Details");
        addbtn.setBounds(250, 500, 150, 50);
        addbtn.setFocusable(false);
        addbtn.addActionListener(this);
        add(addbtn);
        // Backbutton
        backbtn = new JButton("Back");
        backbtn.setBounds(450, 500, 150, 50);
        backbtn.setFocusable(false);
        backbtn.addActionListener(this);
        add(backbtn);

        setTitle("Admin");
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addbtn) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String nid = tfnid.getText();
            String emid = lblemid.getText();
            String deg = tfdeg.getText();
            try {
                Conn conn = new Conn();
                String query = "insert into employee values('" + name + "','" + fname + "','" + dob + "','" + address
                        + "','" + salary + "','" + phone + "','" + email + "','" + deg + "','" + education + "','" + nid
                        + "','" + emid + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
        }
        setVisible(false);
        new home();
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}

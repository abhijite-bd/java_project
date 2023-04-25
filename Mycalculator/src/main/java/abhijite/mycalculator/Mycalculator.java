/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package abhijite.mycalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mycalculator implements ActionListener {

    JFrame frame;
    JTextField textfield,namefield;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD, 24);
    Font myFont2 = new Font("Ink Free", Font.BOLD, 16);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Mycalculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        namefield=new JTextField("ABHIJITE");
        namefield.setHorizontalAlignment(SwingConstants.CENTER);
        namefield.setBackground(Color.LIGHT_GRAY);
        namefield.setFont(myFont2);
        namefield.setEditable(false);
        namefield.setBounds(50, 80, 300, 30);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(true);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");
        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }
        delButton.setBounds(50, 430, 100, 50);
        clrButton.setBounds(150, 430, 100, 50);
        equButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 120, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(negButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(equButton);
        frame.add(textfield);
        frame.add(namefield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Mycalculator calc = new Mycalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButton[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText(null);
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText(null);
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText(null);
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText(null);
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
        if (e.getSource() == equButton) {
            double num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case '+': {
                    result = num1 + num2;
                    textfield.setText(String.valueOf(result));
                    break;
                }
                case '-': {
                    result = num1 - num2;
                    textfield.setText(String.valueOf(result));
                    break;
                }
                case '*': {
                    result = num1 * num2;
                    textfield.setText(String.valueOf(result));
                    break;
                }
                case '/': {
                    if (num2 == 0) {
                        textfield.setText("Math Error!");
                        result = 0;
                    } else {
                        result = num1 / num2;
                        textfield.setText(String.valueOf(result));
                    }
                    break;
                }
            }
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textfield.setText(null);
        }
        if (e.getSource() == delButton) {
            String str = textfield.getText();
            if (!str.equals("Math Error!")) {
                textfield.setText("");
                for (int i = 0; i < str.length() - 1; i++) {
                    textfield.setText(textfield.getText() + str.charAt(i));
                }
            }
        }

    }
}

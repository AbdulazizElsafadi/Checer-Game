package Checker_game;

import javax.swing.*;

public class Learning_Swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Demo");

        JLabel result = new JLabel();
        JLabel operator = new JLabel("+");
        JTextField textField1 = new JTextField("");
        JTextField textField2 = new JTextField("");
        JButton button = new JButton("=");

        button.addActionListener(actionEvent -> {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());

            result.setText(""+(num1+num2));
        });

        textField1.setBounds(40, 40, 70, 50);                       // frame في الـ label هنا قمنا بتحديد حجم و موقع الكائن
        operator.setBounds(120, 50, 50, 30);                  // frame في الـ textField هنا قمنا بتحديد حجم و موقع الكائن
        textField2.setBounds(140, 40, 70, 50);                      // frame في الـ button هنا قمنا بتحديد حجم و موقع الكائن
        button.setBounds(250, 40, 50, 50);
        result.setBounds(350, 40, 80, 80);

        frame.add(textField1);
        frame.add(textField2);
        frame.add(operator);
        frame.add(button);
        frame.add(result);

        frame.setLayout(null);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class MainWhats {
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 500;
    static WhatsApp nh = new WhatsApp();

    public static void main(String[] args) {
        JFrame f = new JFrame();

        JLabel text = new JLabel("message");
        text.setBounds(150, 160, 120, 40);
        f.add(text);

        JTextField textFieldMessage = new JTextField();
        textFieldMessage.setBounds(130, 200, 100, 30);
        f.add(textFieldMessage);

        JLabel jl = new JLabel("insert phone number");
        jl.setBounds(120, 80, 120, 40);
        f.add(jl);

        JTextField textField = new JTextField();
        textField.setBounds(130, 130, 100, 30);
        f.add(textField);

        JLabel errol = new JLabel("");
        errol.setForeground(Color.red);
        errol.setBounds(120, 40, 120, 40);
        f.add(errol);

        JButton button = new JButton("button");
        button.setBounds(0, 0, 100, 40);
        f.add(button);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!isValid(textField.getText())) {
                    errol.setText("invalid phone");
                    return;
                }
                if (textFieldMessage.getText().equals("")) {
                    errol.setText("message is empty");
                    return;
                }
                nh.setMsg(textFieldMessage.getText());
                errol.setText("");
                nh.finder("972" +textField.getText().substring(1));
            }
        });

//        JButton button2 = new JButton("התחברות הצליחה");
//       button2.setBounds(130, 290, 150, 50);
//        f.add(button2);


        JComboBox cb = new JComboBox();
        button.setBounds(130, 260, 100, 40);
        f.add(cb);
        f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
    }
    private static boolean isValid(String tel) {
        return Pattern.compile("^05\\d{8}$").matcher(tel).find();
    }
}




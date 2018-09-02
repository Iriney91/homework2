package lesson4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setLayout(new GridLayout(3, 1));


        JPanel[] jp = new JPanel[3];
        for (int i = 0; i < 3; i++) {
            jp[i] = new JPanel();
            add(jp[i]);
            jp[i].setBackground(new Color(100 + i * 40, 100 + i * 40, 100 + i * 40));
        }


        jp[0].setLayout(new BorderLayout());
        JTextArea jta = new JTextArea();
        jta.disable();
        jta.setDisabledTextColor(Color.black);
        jp[0].add(jta);

        jp[1].setLayout(new BorderLayout());
        JTextField jtf = new JTextField();
        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jtf.getText();
                String text2 = jta.getText();
                jtf.setText("");
                if (text2.length() == 0) {
                    jta.setText(text);
                } else {
                    jta.setText(text2 + "\n" + text);
                }


            }
        });
        jp[1].add(jtf);

        jp[2].setLayout(new BorderLayout());
        JButton jb = new JButton();
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jtf.getText();
                String text2 = jta.getText();
                jtf.setText("");
                if (text2.length() == 0) {
                    jta.setText(text);
                } else {
                    jta.setText(text2 + "\n" + text);
                }


            }
        });

        jb.setText("Enter");
        jp[2].add(jb);

        setVisible(true);
    }


}

public class MainClass {
    public static void main(String[] args) {
        new MyWindow();
    }
}
package org.xgo.swing_learn.vi_components;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class RadioButtons extends JFrame {
    private JTextField t = new JTextField(15);
    // 需要将 JRadioButton 放入 ButtonGroup，才能实现：单选
    private ButtonGroup g = new ButtonGroup();
    private JRadioButton
            rb1 = new JRadioButton("one", false),
            rb2 = new JRadioButton("two", false),
            rb3 = new JRadioButton("three", false);

    public RadioButtons() {
        rb1.addActionListener(e -> {
            t.setText("Radio button：" +
                    ((JRadioButton) e.getSource()).getText());
        });
        rb2.addActionListener(e -> {
            t.setText("Radio button：" +
                    ((JRadioButton) e.getSource()).getText());
        });
        rb3.addActionListener(e -> {
            t.setText("Radio button：" +
                    ((JRadioButton) e.getSource()).getText());
        });

        g.add(rb1);
        g.add(rb2);
        g.add(rb3);

        t.setEditable(false);

        setLayout(new FlowLayout());
        add(t);
        add(rb1);
        add(rb2);
        add(rb3);
    }

    public static void main(String[] args) {
        SwingConsole.run(new RadioButtons(), 500, 500);
    }
}

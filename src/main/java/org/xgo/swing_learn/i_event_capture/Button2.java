package org.xgo.swing_learn.i_event_capture;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import java.awt.*;

/**
 * 按钮事件
 */
public class Button2 extends JFrame {
    private JButton b1 = new JButton("Button 1"),
            b2 = new JButton("Button 2");

    private JTextField txt = new JTextField(10);

    public Button2() {
        b1.addActionListener(e -> {
            String name = ((JButton) e.getSource()).getText();
            txt.setText(name);
        });

        b2.addActionListener(e -> {
            String name = ((JButton) e.getSource()).getText();
            txt.setText(name);
        });

        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button2(), 200, 150);
    }
}

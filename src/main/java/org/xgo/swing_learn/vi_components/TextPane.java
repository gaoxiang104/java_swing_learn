package org.xgo.swing_learn.vi_components;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TextPane extends JFrame {

    private JButton b = new JButton("Add Text");
    private JTextPane tp = new JTextPane();
    private Random rand = new Random();

    public TextPane() {

        b.addActionListener(e -> {
            for (int i = 0; i < 3; i++) {
                String str = String.format("%s%d:%d\n", tp.getText(), i, rand.nextInt(100));
                tp.setText(str);
            }
        });

        add(new JScrollPane(tp));
        add(BorderLayout.NORTH, b);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextPane(), 500, 500);
    }

}

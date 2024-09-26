package org.xgo.swing_learn.vi_components;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import java.awt.*;

/**
 * 组合框
 */
public class ComboBoxes extends JFrame {
    private String[] description = {"Ebullient", "Obtuse", "Recalcitrant",
            "Brilliant", "Somnescent", "Timorous", "Florid", "Putrescent","cry"};

    private JTextField t = new JTextField(15);
    private JComboBox c = new JComboBox();
    private JButton b = new JButton("Add items");
    private int count = 0;

    public ComboBoxes() {
        for (int i = 0; i < 4; i++) {
            c.addItem(description[count++]);
        }

        t.setEditable(false);

        b.addActionListener(e -> {
            if (count < description.length) {
                c.addItem(description[count++]);
            }
        });

        c.addActionListener(e -> {
            t.setText("index: " + c.getSelectedIndex() + "  " +
                    ((JComboBox) e.getSource()).getSelectedItem());
        });

        setLayout(new FlowLayout());
        add(t);
        add(c);
        add(b);
    }

    public static void main(String[] args) {
        SwingConsole.run(new ComboBoxes(), 200, 175);
    }
}

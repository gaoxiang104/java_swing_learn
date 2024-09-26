package org.xgo.swing_learn.vi_components;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class CheckBoxes extends JFrame {

    private JTextArea t = new JTextArea(6, 15);

    private JCheckBox cb1 = new JCheckBox("Check Box 1"),
            cb2 = new JCheckBox("Check Box 2"),
            cb3 = new JCheckBox("Check Box 3");

    public CheckBoxes() {
        cb1.addActionListener(e -> trace("1", cb1));
        cb2.addActionListener(e -> trace("2", cb1));
        cb3.addActionListener(e -> trace("3", cb1));

        setLayout(new FlowLayout());
        add(new JScrollPane(t));
        add(cb1);
        add(cb2);
        add(cb3);
    }

    private void trace(String b, JCheckBox cb) {
        if (cb.isSelected()) {
            t.append("Box " + b + " Set\n");
        } else {
            t.append("Box " + b + " Cleared\n");
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new CheckBoxes(), 200, 300);
    }
}

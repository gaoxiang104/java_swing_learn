package org.xgo.swing_learn.ii_layout;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import java.awt.*;

/**
 * 边界布局
 */
public class BorderLayout1 extends JFrame {
    public BorderLayout1() {
        add(BorderLayout.NORTH, new JButton("North"));
        add(BorderLayout.SOUTH, new JButton("South"));
        add(BorderLayout.EAST, new JButton("East"));
        add(BorderLayout.WEST, new JButton("West"));
        add(BorderLayout.CENTER, new JButton("center"));
    }

    public static void main(String[] args) {
        SwingConsole.run(new BorderLayout1(), 300, 250);
    }
}

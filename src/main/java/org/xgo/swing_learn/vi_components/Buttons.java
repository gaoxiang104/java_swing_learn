package org.xgo.swing_learn.vi_components;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

/**
 * 不同的按钮
 */
public class Buttons extends JFrame {
    private JButton jb = new JButton("JButton");

    private BasicArrowButton  // 基本箭头按钮
        up = new BasicArrowButton(BasicArrowButton.NORTH),
        down = new BasicArrowButton(BasicArrowButton.SOUTH),
        right = new BasicArrowButton(BasicArrowButton.EAST),
        left = new BasicArrowButton(BasicArrowButton.WEST);

    public Buttons () {
        setLayout(new FlowLayout());
        add(jb);

        add(new JToggleButton("JToggleButton")); // 切换按钮
        add(new JCheckBox("JCheckBox"));
        add(new JRadioButton("JRadioButton"));

        JPanel jp = new JPanel();
        jp.setBorder(new TitledBorder("Directions"));
        jp.add(up);
        jp.add(down);
        jp.add(left);
        jp.add(right);
        add(jp);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Buttons(), 350,250);
    }
}

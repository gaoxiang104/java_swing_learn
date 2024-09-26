package org.xgo.swing_learn.vi_components;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * 边框
 */
public class Borders extends JFrame {
    static JPanel showBorder(Border b) {
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        String nm = b.getClass().toString();
        nm = nm.substring(nm.lastIndexOf(".") + 1);
        jp.add(new JLabel(nm, JLabel.CENTER), BorderLayout.CENTER);
        jp.setBorder(b);
        return jp;
    }

    public Borders() {
        setLayout(new GridLayout(2, 4));
        add(showBorder(new TitledBorder(new LineBorder(Color.MAGENTA,3),"Title"))); // 标题边框
        add(showBorder(new EtchedBorder())); // 蚀刻边框
        add(showBorder(new LineBorder(Color.BLUE))); // 线条边框
        add(showBorder(new MatteBorder(1, 1, 5, 5, Color.GREEN))); // 遮罩边框
        add(showBorder(new BevelBorder(BevelBorder.LOWERED))); // 斜面边框
        // 复合边框
        add(showBorder(new CompoundBorder(
                new EtchedBorder(),
                new LineBorder(Color.RED)
        )));
    }

    public static void main(String[] args) {
        SwingConsole.run(new Borders(), 500, 300);
    }
}

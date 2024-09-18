package org.xgo.swing_learn.common;

import javax.swing.*;

/**
 * 显示框架
 */
public class SwingConsole {
    public static void run(final JFrame f, final int width, final int height) {
        f.setTitle(f.getClass().getSimpleName());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(width, height);
        f.setLocationRelativeTo(null); // 位置为null时，在屏幕中间显示
        f.setVisible(true);
    }
}

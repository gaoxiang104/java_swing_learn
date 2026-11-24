package org.xgo.swing_learn.z_demo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class HelpIconDemo extends JFrame {

    public HelpIconDemo() {
        setTitle("帮助图标 (问号) 示例");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        // 创建一个只显示图标、不显示文字的 JLabel
        JLabel helpLabel = new JLabel(new QuestionMarkIcon(18, Color.BLUE));

        // 设置鼠标悬停时显示的提示文字
        helpLabel.setToolTipText("这里是详细的帮助说明信息...");

        add(new JLabel("Radius:"));
        add(new JTextField(10));
        add(helpLabel); // 将帮助图标放在输入框旁边

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HelpIconDemo().setVisible(true));
    }

    /**
     * 自定义 Icon 实现：绘制一个圆圈，并在中间画一个问号
     */
    static class QuestionMarkIcon implements Icon {
        private final int size;
        private final Color color;

        public QuestionMarkIcon(int size, Color color) {
            this.size = size;
            this.color = color;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            // 开启抗锯齿，让圆圈和文字边缘更平滑
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // 1. 画圆圈边框 (不填充，只描边)
            g2.setColor(color);
            g2.setStroke(new BasicStroke(1.5f));
            g2.draw(new Ellipse2D.Double(x + 1, y + 1, size - 2, size - 2));

            // 2. 画中间的 "?" 符号
            String questionMark = "?";
            g2.setFont(new Font("SansSerif", Font.BOLD, size - 6));
            FontMetrics fm = g2.getFontMetrics();

            // 计算文字居中位置
            int textX = x + (size - fm.stringWidth(questionMark)) / 2;
            int textY = y + (fm.getAscent() + (size - (fm.getAscent() + fm.getDescent())) / 2);

            g2.drawString(questionMark, textX, textY);
            g2.dispose();
        }

        @Override
        public int getIconWidth() { return size; }

        @Override
        public int getIconHeight() { return size; }
    }
}

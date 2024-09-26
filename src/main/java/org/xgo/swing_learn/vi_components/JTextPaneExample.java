package org.xgo.swing_learn.vi_components;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class JTextPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html"); // 设置为HTML格式（可选）

        // 创建StyledDocument
        StyledDocument doc = textPane.getStyledDocument();

        // 创建不同的样式
        Style style1 = textPane.addStyle("Style1", null);
        StyleConstants.setFontFamily(style1, "Arial");
        StyleConstants.setFontSize(style1, 16);
        StyleConstants.setForeground(style1, Color.RED);
        StyleConstants.setBold(style1, true);

        Style style2 = textPane.addStyle("Style2", null);
        StyleConstants.setFontFamily(style2, "Courier New");
        StyleConstants.setFontSize(style2, 14);
        StyleConstants.setForeground(style2, Color.BLUE);
        StyleConstants.setItalic(style2, true);

        try {
            // 添加不同样式的文本
            doc.insertString(doc.getLength(), "This is red bold text.\n", style1);
            doc.insertString(doc.getLength(), "This is blue italic text.\n", style2);
            doc.insertString(doc.getLength(), "This is normal text.", null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // 将JTextPane添加到JFrame
        frame.add(new JScrollPane(textPane));
        frame.setVisible(true);
    }
}


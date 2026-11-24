package org.xgo.swing_learn.ii_layout;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class GridBagLayout1 extends JFrame {
    public GridBagLayout1() {

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 设置通用的边距
        gbc.insets = new Insets(5, 5, 5, 5);

        // 第一行：标题
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6; // 跨越4列
        gbc.fill = GridBagConstraints.HORIZONTAL; // 填充水平方向
        gbc.anchor = GridBagConstraints.CENTER; // 居中对齐
        mainPanel.add(new JLabel("用户注册表单", JLabel.CENTER), gbc);

        // 重置gridwidth
        gbc.gridwidth = 1;

        // 第二行：姓名
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(new JLabel("姓名:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        mainPanel.add(new JTextField(8), gbc);

        // 重置gridwidth
        gbc.gridwidth = 1;

        gbc.gridx = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(new JLabel("年龄:"), gbc);

        gbc.gridx = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        mainPanel.add(new JTextField(5), gbc);

        // 重置gridwidth
        gbc.gridwidth = 1;

        // 第三行：邮箱
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(new JLabel("邮箱:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        mainPanel.add(new JTextField(20), gbc);

        // 重置gridwidth
        gbc.gridwidth = 1;

        // 第四行：性别
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(new JLabel("性别:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(new JRadioButton("男"), gbc);

        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.NONE;
        mainPanel.add(new JRadioButton("女"), gbc);


        // 第五行：爱好
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.NORTHWEST;  // 居右
        mainPanel.add(new JLabel("爱好:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        JTextArea hobbyArea = new JTextArea(3,20);
        hobbyArea.setBorder(BorderFactory.createLoweredBevelBorder());
        mainPanel.add(new JScrollPane(hobbyArea), gbc);

        // 重置gridwidth
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;

        // 第六行：按钮
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(new JButton("提交"), gbc);

        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(new JButton("取消"), gbc);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingConsole.run(new GridBagLayout1(), 400, 300);
    }
}

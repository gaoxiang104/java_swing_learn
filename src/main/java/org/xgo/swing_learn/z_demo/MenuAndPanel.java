package org.xgo.swing_learn.z_demo;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuAndPanel extends JFrame {
    private JButton menuBtn1;
    private JButton menuBtn2;

    private JPanel currentPanel; // 用于跟踪当前显示的面板
    private JPanel panel1;
    private JPanel panel2;

    public MenuAndPanel() {

        menuBtn1 = new JButton("菜单按钮1");
        menuBtn2 = new JButton("菜单按钮2");

        JPanel jPanel0 = new JPanel();
        jPanel0.add(new JLabel("面板0"));
        currentPanel = jPanel0;

        panel1 = new JPanel();
        panel1.add(new JLabel("面板1"));
        panel2 = new JPanel();
        panel2.add(new JLabel("面板2"));

        // 创建菜单Panel
        JPanel btnPanel = new JPanel(new GridBagLayout());
//        btnPanel.setBorder(new EtchedBorder());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;


        btnPanel.add(menuBtn1, gbc);
        btnPanel.add(menuBtn2, gbc);
//        btnPanel.add(new JButton("菜单按钮3"), gbc);
//        btnPanel.add(new JButton("菜单按钮4"), gbc);
//        btnPanel.add(new JButton("菜单按钮5"), gbc);
//        btnPanel.add(new JButton("菜单按钮6"), gbc);
//        btnPanel.add(new JButton("菜单按钮7"), gbc);
//        btnPanel.add(new JButton("菜单按钮8"), gbc);
//        btnPanel.add(new JButton("菜单按钮9"), gbc);
//        btnPanel.add(new JButton("菜单按钮10"), gbc);
//        btnPanel.add(new JButton("菜单按钮11"), gbc);

        // 关键：添加一个占位组件，占用剩余空间
        GridBagConstraints filler = new GridBagConstraints();
        filler.gridwidth = GridBagConstraints.REMAINDER;
        filler.weighty = 1.0; // 占据所有剩余垂直空间
        filler.fill = GridBagConstraints.VERTICAL;
        btnPanel.add(Box.createVerticalGlue(), filler);

        // 将btnPanel放入滚动面板中
        JScrollPane scrollPane = new JScrollPane(btnPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // 替代方案：使用Border来控制边距
        EmptyBorder normalBorder = new EmptyBorder(5, 5, 5, 5);
        EmptyBorder withScrollBorder = new EmptyBorder(5, 5, 5, 20);

        // 监听滚动条状态
        scrollPane.getVerticalScrollBar().addAdjustmentListener(e -> {
            if (scrollPane.getVerticalScrollBar().isVisible()) {
                btnPanel.setBorder(withScrollBorder);
            } else {
                btnPanel.setBorder(normalBorder);
            }
            btnPanel.revalidate();
            btnPanel.repaint();
        });

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.WEST);
        add(jPanel0, BorderLayout.CENTER);

        // 添加事件
        menuBtn1.addActionListener(e -> {
            switchPanel(panel1);
        });
        menuBtn2.addActionListener(e -> {
            switchPanel(panel2);
        });
    }

    private void switchPanel(JPanel newPanel) {
        if (currentPanel != newPanel) {
            remove(currentPanel);  // 从容器中移除当前面板
            currentPanel = newPanel;
            add(currentPanel, BorderLayout.CENTER);  // 添加新面板到中心区域
            revalidate(); // 重新布局
            repaint(); // 重新绘制
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new MenuAndPanel(), 1024, 768);
    }

}

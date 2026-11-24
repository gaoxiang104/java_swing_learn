package org.xgo.swing_learn.z_demo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ToggleRadioDemo extends JFrame {

    private final List<JRadioButton> radios = new ArrayList<>();
    private final ButtonGroup group = new ButtonGroup();

    // 👇 关键：记录"上一次被选中的按钮"
    private JRadioButton lastSelected = null;

    public ToggleRadioDemo() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        for (int i = 1; i <= 3; i++) {
            JRadioButton rb = new JRadioButton("R-选项" + i);
            rb.setActionCommand("R-选项" + i);
            group.add(rb);
            radios.add(rb);
            form.add(rb);

            // 👇 核心逻辑
            rb.addActionListener(e -> {
                if (!rb.isSelected()) return;

                if (rb == lastSelected) {
                    // 直接调用 group 的 clearSelection() 来清空所有选中
                    group.clearSelection();
                    lastSelected = null;
                } else {
                    lastSelected = rb;
                }
            });
        }

        add(form, BorderLayout.CENTER);

        // 查看状态的按钮
        JButton show = new JButton("查看当前选中");
        show.addActionListener(e -> {
            ButtonModel m = group.getSelection();
            String s = (m == null) ? "未选中任何项" : m.getActionCommand();
            JOptionPane.showMessageDialog(this, "当前选中: " + s);
        });
        add(show, BorderLayout.SOUTH);

        setTitle("可取消的单选 RadioButton");
        setSize(300, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToggleRadioDemo().setVisible(true));
    }
}
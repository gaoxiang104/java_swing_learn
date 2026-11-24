package org.xgo.swing_learn.z_demo;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FormPanel_D1 extends JFrame {

    // 多选：保存所有 checkbox 的引用
    private final List<JCheckBox> checkBoxes = new ArrayList<>();
    // 单选：保存所有 radio + 一个 group
    private final List<JRadioButton> radioButtons = new ArrayList<>();
    private final ButtonGroup radioGroup = new ButtonGroup();

    public FormPanel_D1() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        // ---- 多选：C-选项1/2/3 ----
        form.add(new JLabel("多选："));
        for (int i = 1; i <= 3; i++) {
            JCheckBox cb = new JCheckBox("C-选项" + i);
            cb.setActionCommand("C-选项" + i); // 建议显式设 actionCommand 作为"值"
            checkBoxes.add(cb);
            form.add(cb);
        }

        form.add(Box.createVerticalStrut(10));

        // ---- 单选：R-选项1/2/3 ----
        form.add(new JLabel("单选："));
        for (int i = 1; i <= 3; i++) {
            JRadioButton rb = new JRadioButton("R-选项" + i);
            rb.setActionCommand("R-选项" + i);
            radioButtons.add(rb);
            radioGroup.add(rb);   // 👈 关键：加入 ButtonGroup 才互斥
            form.add(rb);
        }
        // 可选：默认选中第一个
        radioButtons.get(0).setSelected(true);

        add(form, BorderLayout.CENTER);

        // ---- 提交按钮 ----
        JButton submit = new JButton("提交");
        submit.addActionListener(e -> onSubmit());
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.add(submit);
        add(bottom, BorderLayout.SOUTH);
    }

    private void onSubmit() {
        // ① 获取多选：哪些被勾选
        List<String> checked = new ArrayList<>();
        for (JCheckBox cb : checkBoxes) {
            if (cb.isSelected()) {
                checked.add(cb.getActionCommand()); // 或用 cb.getText()
            }
        }

        // ② 获取单选：当前选中的那个
        String selectedRadio = null;
        ButtonModel model = radioGroup.getSelection();
        if (model != null) {
            selectedRadio = model.getActionCommand();
        }

        System.out.println("多选勾选：" + checked);        // 如 [C-选项1, C-选项3]
        System.out.println("单选选中：" + selectedRadio);  // 如 R-选项2，或 null

        // 也可以提示给用户
        JOptionPane.showMessageDialog(this,
                "多选勾选: " + checked + "\n单选选中: " + selectedRadio);
    }

    public static void main(String[] args) {
        SwingConsole.run(new FormPanel_D1(), 500, 400);
    }
}
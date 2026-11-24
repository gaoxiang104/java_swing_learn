package org.xgo.swing_learn.z_demo.eventBusDemo;

import javax.swing.*;
import java.awt.*;

public class PanelB extends JPanel {
    private JLabel displayLabel;

    public PanelB() {
        initializeUI();
        setEventHandling();
    }

    private void initializeUI() {
        setBorder(BorderFactory.createTitledBorder("PanelB容器 - 显示区域"));
        setLayout(new BorderLayout());

        displayLabel = new JLabel("等待按钮点击...", JLabel.CENTER);
        displayLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        displayLabel.setForeground(Color.BLUE);

        add(displayLabel, BorderLayout.CENTER);
    }

    private void setEventHandling() {
        SimpleEventBus.subscribe(AppEvents.LabelUpdateRequestEvent.class, event -> {
            System.out.println("PanelB收到事件：" + event);
            displayLabel.setText(event.newText);
            displayLabel.setForeground(event.newText.contains("1") ? Color.RED : Color.GREEN);
        });

    }
}

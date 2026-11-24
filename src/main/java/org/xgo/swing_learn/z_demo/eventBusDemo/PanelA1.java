package org.xgo.swing_learn.z_demo.eventBusDemo;

import javax.swing.*;
import java.awt.*;

public class PanelA1 extends JPanel {
    private JButton button1;
    private int clickCount;

    public PanelA1() {
        initializeUI();
        setEventHandling();
    }

    /**
     * 初始化用户界面组件
     * 该方法负责创建和布置面板中的所有UI元素，包括设置边框、布局管理器和添加按钮
     */
    private void initializeUI() {
        // 设置面板边框样式，创建带标题的边框
        setBorder(BorderFactory.createTitledBorder("PanelA1"));
        // 设置布局管理器为流式布局
        setLayout(new FlowLayout());

        // 创建按钮并添加到面板中
        button1 = new JButton("Button1 - 点击我");
        add(button1);
    }

    /**
     * 设置事件处理逻辑
     */
    private void setEventHandling() {
        // 为button1添加 ActionListener 监听器
        button1.addActionListener(e -> {
            clickCount++;
            // 创建按钮点击事件对象，包含面板标识和点击次数信息
            AppEvents.ButtonClickEvent event = new AppEvents.ButtonClickEvent("PanelA1",
                    "Button1 点击次数：" + clickCount);
            System.out.println("发布事件：" + event);
            // 通过SimpleEventBus发布事件
            SimpleEventBus.publish(event);
        });
    }

}

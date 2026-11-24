package org.xgo.swing_learn.z_demo.eventBusDemo;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {
    public MainApp() {
        initializeUI();
        setupApplication();
    }

    private void initializeUI() {
        setTitle("极简事件总线案例");
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelA panelA = new PanelA();
        add(panelA);
        PanelB panelB = new PanelB();
        add(panelB);

        setSize(1024, 768);
        setLocationRelativeTo(null);
    }

    private void setupApplication() {
        // 启动业务协调器 - 这是连接所有组件的核心
        new AppCoordinator();
        System.out.println("应用程序启动完成，事件总线已就绪");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainApp().setVisible(true);
        });

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭事件总线...");
            SimpleEventBus.shutdown();
        }));
    }
}

package org.xgo.swing_learn.z_demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginDemo extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public LoginDemo() {
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        setupWindow();
    }

    // 初始化组件
    private void initializeComponents() {
        // 创建用户名相关组件
        JLabel usernameLabel = new JLabel("用户名:");
        usernameField = new JTextField(15);

        // 创建密码相关组件
        JLabel passwordLabel = new JLabel("密码:");
        passwordField = new JPasswordField(15);

        // 创建按钮
        loginButton = new JButton("登录");
        cancelButton = new JButton("取消");

        // 设置按钮首选大小
        Dimension buttonSize = new Dimension(80, 25);
        loginButton.setPreferredSize(buttonSize);
        cancelButton.setPreferredSize(buttonSize);
    }

    // 设置布局
    private void setupLayout() {
        // 设置主面板布局
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 创建输入面板（用户名和密码）
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // 用户名行
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(new JLabel("用户名:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        inputPanel.add(usernameField, gbc);

        // 密码行
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        inputPanel.add(new JLabel("密码:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        inputPanel.add(passwordField, gbc);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);

        // 组装主面板
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 设置内容面板
        setContentPane(mainPanel);
    }

    // 设置事件处理
    private void setupEventHandlers() {
        // 登录按钮事件处理
        loginButton.addActionListener(e -> handleLogin());

        // 取消按钮事件处理
        cancelButton.addActionListener(e -> System.exit(0));

        // 回车键登录功能
        ActionListener loginAction = e -> handleLogin();

        usernameField.addActionListener(loginAction);
        passwordField.addActionListener(loginAction);
    }

    // 登录处理

    private void handleLogin() {
        String username = usernameField.getText().trim();
        char[] password = passwordField.getPassword();

        // 简单验证
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "请输入用户名！", "提示", JOptionPane.WARNING_MESSAGE);
            usernameField.requestFocus();
            return;
        }

        if (password.length == 0) {
            JOptionPane.showMessageDialog(this,
                    "请输入密码！", "提示", JOptionPane.WARNING_MESSAGE);
            passwordField.requestFocus();
            return;
        }

        // 模拟登录验证（实际项目中应连接数据库或调用API验证）
        if ("admin".equals(username) && "123456".equals(new String(password))) {
            JOptionPane.showMessageDialog(this,
                    "登录成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            // 这里可以打开主程序窗口
            // dispose(); // 关闭登录窗口
        } else {
            JOptionPane.showMessageDialog(this,
                    "用户名或密码错误！", "登录失败", JOptionPane.ERROR_MESSAGE);
            passwordField.selectAll();
            passwordField.requestFocus();
        }

        // 清除密码字段以提高安全性
        Arrays.fill(password, '0');
    }

    private void setupWindow() {
        setTitle("用户登录");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 设置窗口大小并居中
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // 设置系统外观
        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 在事件调度线程中创建和显示GUI Java基础
        SwingUtilities.invokeLater(() -> new LoginDemo().setVisible(true));
    }
}


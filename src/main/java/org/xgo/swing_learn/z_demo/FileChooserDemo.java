package org.xgo.swing_learn.z_demo;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class FileChooserDemo extends JFrame {
    private JTextArea textArea;
    private JButton openButton;
    private JButton saveButton;
    private JButton selectDirButton;
    private JButton multiSelectButton; // 选择多个文件

    public FileChooserDemo() throws HeadlessException {
        setTitle("JFileChooser 示例");

        textArea = new JTextArea();
        openButton = new JButton("打开文件");
        saveButton = new JButton("保存文件");
        selectDirButton = new JButton("选择目录");
        multiSelectButton = new JButton("多文件选择");

        // 设置布局
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(selectDirButton);
        buttonPanel.add(multiSelectButton);

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // 添加监听：打开文件
        openButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("选择要打开的文件");
            fileChooser.setCurrentDirectory(new File("."));

            // 设置文件过滤器
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "java文件（*.java）", "java");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(FileChooserDemo.this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                textArea.setText("已选择文件：" + selectedFile.getAbsolutePath());
            } else {
                textArea.setText("用户取消了文件选择");
            }
        });

        // 添加监听：保存文件
        saveButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("保存文件");
            fileChooser.setCurrentDirectory(new File("."));

            int result = fileChooser.showSaveDialog(FileChooserDemo.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                textArea.setText("已选择文件：" + selectedFile.getAbsolutePath());
            } else {
                textArea.setText("用户取消了文件选择");
            }
        });

        // 添加监听：选择目录
        selectDirButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("选择目录");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setCurrentDirectory(new File("."));

            int result = fileChooser.showOpenDialog(FileChooserDemo.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                textArea.setText("已选择目录：" + selectedFile.getAbsolutePath());
            } else {
                textArea.setText("用户取消了目录选择");
            }
        });

        // 添加监听：多文件选择
        multiSelectButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("多文件选择");
            fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setCurrentDirectory(new File("."));
            int result = fileChooser.showOpenDialog(FileChooserDemo.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File[] selectedFiles = fileChooser.getSelectedFiles();
                StringBuilder sb = new StringBuilder();
                sb.append("已选择文件：\n");
                for (File file : selectedFiles) {
                    sb.append(file.getAbsolutePath()).append("\n");
                }
                textArea.setText(sb.toString());
            } else {
                textArea.setText("用户取消了文件选择");
            }
        });
    }

    public static void main(String[] args) {
        SwingConsole.run(new FileChooserDemo(), 500, 400);
    }
}

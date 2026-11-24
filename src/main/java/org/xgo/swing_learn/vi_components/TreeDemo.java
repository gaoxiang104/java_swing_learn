package org.xgo.swing_learn.vi_components;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.Objects;

/**
 * 树结构
 */

public class TreeDemo extends JFrame {

    private static long counter = 0l;

    public TreeDemo() {


        JPanel leftMenuPanel = new JPanel();
        leftMenuPanel.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();

        Button add = new Button("Add");


        Button edit = new Button("Edit");
        Button del = new Button("Del");

        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 3));
        menuPanel.add(add);
        menuPanel.add(edit);
        menuPanel.add(del);

        leftMenuPanel.add(menuPanel, BorderLayout.NORTH);

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(generateNode());
        JTree tree = new JTree(rootNode);

        leftMenuPanel.add(new JScrollPane(tree), BorderLayout.CENTER);

        add(leftMenuPanel);


        // 事件
        add.addActionListener((e -> {
            System.out.println("点击了 ADD");
            TreePath selectionPath = tree.getSelectionPath();
            if (null == selectionPath) return;
            System.out.println(selectionPath);
            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
            System.out.println(parentNode);

//            System.out.println(node.);
            MyTreeNode userObject = (MyTreeNode) parentNode.getUserObject();
            System.out.println(userObject.getId());
            userObject.setName("改-"+userObject.getId());

//            parentNode.setUserObject(userObject);

            // 添加节点
            DefaultMutableTreeNode addNode = new DefaultMutableTreeNode(generateNode());
            parentNode.add(addNode);
            ((DefaultTreeModel) tree.getModel()).nodeStructureChanged(parentNode);
            tree.updateUI();

            /// 展开所有节点
            TreePath pathForRow = tree.getPathForRow(0);
            System.out.println("pathForRow : " + pathForRow);
            expandAllNodes(tree, pathForRow);

            // 获取新节点的路径
            TreePath newPath = new TreePath(addNode.getPath());
            // 选中新节点
            tree.setSelectionPath(newPath);
        }));
    }

    // 递归展开所有节点
    private static void expandAllNodes(JTree tree, TreePath pathForRow) {

        tree.expandPath(pathForRow); // 展开节点

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) pathForRow.getLastPathComponent();
        System.out.println("node : " + node);
        if (node.getChildCount() > 0) {
            for (int i = 0; i < node.getChildCount(); i++) {
                DefaultMutableTreeNode childAt = (DefaultMutableTreeNode) node.getChildAt(i);
                // 获取新节点的路径
                TreePath newPath = new TreePath(childAt.getPath());
                expandAllNodes(tree, newPath);
            }
        }
    }

    private MyTreeNode generateNode() {
        return new MyTreeNode(++counter, null, "目录" + counter);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TreeDemo(), 800, 600);
    }
}

class MyTreeNode {
    private Long id;
    private Long parentId;
    private String name;

    public MyTreeNode() {
    }

    public MyTreeNode(Long id, Long parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTreeNode that = (MyTreeNode) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
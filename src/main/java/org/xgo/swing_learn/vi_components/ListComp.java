package org.xgo.swing_learn.vi_components;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * 列表框
 */
public class ListComp extends JFrame {

    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };

    private DefaultListModel lItems = new DefaultListModel();
    private JList lst = new JList(lItems);
    private JTextArea t = new JTextArea(flavors.length, 20);
    private JButton b = new JButton("Add Item");
    private int count = 0;

    public ListComp() {
        t.setEditable(false);

        setLayout(new FlowLayout());

        Border brd = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.black);

        lst.setBorder(brd);
        t.setBorder(brd);

        for (int i = 0; i < 4; i++) {
            lItems.addElement(flavors[count++]);
        }

        lst.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) return;
            t.setText("");
            for (Object o : lst.getSelectedValuesList()) {
                t.append(o.toString() + "\n");
            }
        });

        b.addActionListener(e -> {
            if (count < flavors.length) {
                lItems.add(0, flavors[count++]);
            } else {
                b.setEnabled(false);
            }
        });

        add(new JScrollPane(t));
        add(new JScrollPane(lst));
        add(b);
    }

    public static void main(String[] args) {
        SwingConsole.run(new ListComp(), 250, 375);
    }
}

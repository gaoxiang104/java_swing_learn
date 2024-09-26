package org.xgo.swing_learn.vi_components;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 文本域
 */
public class TextFields extends JFrame {
    private JButton b1 = new JButton("Get Text");
    private JButton b2 = new JButton("Ste Text");

    private JTextField t1 = new JTextField(30);
    private JTextField t2 = new JTextField(30);
    private JTextField t3 = new JTextField(30);

    private String s = "";

    private UpperCaseDocument ucd = new UpperCaseDocument();

    private int t1Count = 0;

    public TextFields() {
        t1.setDocument(ucd);
        ucd.addDocumentListener(new T1());

        b1.addActionListener(e -> {
            if (t1.getSelectedText() == null) {
                s = t1.getText();
            } else {
                s = t1.getSelectedText();
            }
            t1.setEditable(true);
        });

        b2.addActionListener(e -> {
            ucd.setUpperCase(false);
            t1.setText("inserted by Button 2: " + s);
            ucd.setUpperCase(true);
            t1.setEditable(false);
        });

        t1.addActionListener(e -> {
            System.out.println("t1.addActionListener in .....");
            t3.setText("t1 Action Event " + t1Count++);
        });

        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(t1);
        add(t2);
        add(t3);
    }

    private class UpperCaseDocument extends PlainDocument {
        private boolean upperCase = true;

        public void setUpperCase(boolean flag) {
            this.upperCase = flag;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (upperCase) str = str.toUpperCase();
            super.insertString(offs, str, a);
        }


    }

    private class T1 implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            t2.setText(t1.getText());
            t3.setText("Text: " + t1.getText());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            t2.setText(t1.getText());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextFields(), 500, 200);
    }
}

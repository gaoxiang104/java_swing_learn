package org.xgo.swing_learn.iii_event;

import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 跟踪多个事件
 */
public class TrackEvent extends JFrame {
    private Map<String, JTextField> h = new HashMap<>();

    private String[] event = {
            "focusGained", "focusLost", "keyPressed",
            "keyReleased", "keyTyped", "mouseClicked",
            "mouseEntered", "mouseExited", "mousePressed",
            "mouseReleased", "mouseDragged", "mouseMoved"
    };

    class MyButton extends JButton {
        void report(String field, String msg) {
            h.get(field).setText(msg);
        }

        FocusListener f1 = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                report("focusGained", e.paramString());
            }

            @Override
            public void focusLost(FocusEvent e) {
                report("focusLost", e.paramString());
            }
        };

        KeyListener k1 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                report("keyTyped", e.paramString());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                report("keyPressed", e.paramString());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                report("keyReleased", e.paramString());
            }
        };

        MouseListener m1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                report("mouseClicked", e.paramString());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                report("mousePressed", e.paramString());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                report("mouseReleased", e.paramString());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                report("mouseEntered", e.paramString());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                report("mouseExited", e.paramString());
            }
        };

        MouseMotionListener mml = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                report("mouseDragged", e.paramString());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                report("mouseMoved", e.paramString());
            }
        };

        public MyButton(Color color, String label) {
            super(label);
            setBackground(color);
            addFocusListener(f1);
            addKeyListener(k1);
            addMouseListener(m1);
            addMouseMotionListener(mml);
        }
    }

    private MyButton b1 = new MyButton(Color.pink, "test1");
    private MyButton b2 = new MyButton(Color.getHSBColor(133,133,133), "test2");

    public TrackEvent() {
        setLayout(new GridLayout(event.length + 1, 2));
        for (String evt : event) {
            JTextField t = new JTextField();
            t.setEditable(false);
            JLabel jLabel = new JLabel(evt + ": ", JLabel.RIGHT);
            add(jLabel);
            add(t);
            h.put(evt, t);
        }
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TrackEvent(), 700, 500);
    }
}

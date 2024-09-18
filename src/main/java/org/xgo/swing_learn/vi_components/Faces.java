package org.xgo.swing_learn.vi_components;

import org.xgo.swing_learn.common.SwingConsole;
import org.xgo.swing_learn.common.components.ImageIconUtils;

import javax.swing.*;
import java.awt.*;

public class Faces extends JFrame {
    private static Icon[] faces;
    private JButton jb, jb2 = new JButton("Disable");
    private boolean mad = false;

    public Faces() {
        faces = new Icon[]{
                ImageIconUtils.generator("/assets/icon/order.png", 32, 32),
                ImageIconUtils.generator("/assets/icon/star.png",32,32),
                ImageIconUtils.generator("/assets/icon/user.png",32,32),
                ImageIconUtils.generator("/assets/icon/view.png",32,32),
                ImageIconUtils.generator("/assets/icon/image.png",32,32),
        };

        jb = new JButton("JButton", faces[0]);
        setLayout(new FlowLayout());
        jb.addActionListener(e -> {
            if (mad) {
                jb.setIcon(faces[3]);
                mad = false;
            } else {
                jb.setIcon(faces[0]);
                mad = true;
            }
            jb.setVerticalAlignment(JButton.TOP); // 垂直对齐
            jb.setHorizontalAlignment(JButton.LEFT); // 水平对齐
        });

        jb.setRolloverEnabled(true);
        jb.setRolloverIcon(faces[1]);
        jb.setPressedIcon(faces[2]);
        jb.setDisabledIcon(faces[4]);
        jb.setToolTipText("Yow!");
        add(jb);

        jb2.addActionListener(e -> {
            if (jb.isEnabled()) {
                jb.setEnabled(false);
                jb2.setText("Enable");
            } else {
                jb.setEnabled(true);
                jb2.setText("Disable");
            }
        });
        add(jb2);
    }


    public static void main(String[] args) {
        SwingConsole.run(new Faces(), 800 , 600);
    }
}

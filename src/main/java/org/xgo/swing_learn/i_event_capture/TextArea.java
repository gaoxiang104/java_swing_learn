package org.xgo.swing_learn.i_event_capture;

import org.xgo.swing_learn.common.SwingConsole;
import org.xgo.swing_learn.common.data.CountryData;

import javax.swing.*;
import java.awt.*;

public class TextArea extends JFrame {
    private JButton b = new JButton("Add Data"),
            c = new JButton("Claer Data");

    private JTextArea t = new JTextArea(20, 40);

    public TextArea() {

        b.addActionListener(e -> {
            CountryData.COUNTRY_CAPITAL_MAP.forEach((country, capital) -> {
                t.append(country + ": " + capital + "\n");
            });
        });

        c.addActionListener(e -> {
            t.setText("");
        });

        setLayout(new FlowLayout());
        add(new JScrollPane(t));
        add(b);
        add(c);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextArea(), 475, 425);
    }
}

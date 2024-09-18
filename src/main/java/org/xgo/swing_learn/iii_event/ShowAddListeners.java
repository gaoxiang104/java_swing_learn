package org.xgo.swing_learn.iii_event;

import org.apache.commons.lang3.StringUtils;
import org.xgo.swing_learn.common.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowAddListeners extends JFrame {

    private JTextField name = new JTextField(25);
    private JTextArea results = new JTextArea(40, 65);

    private static Pattern addListener = Pattern.compile("(add\\w+?Listener\\(.*?\\))");
    private static Pattern qualifier = Pattern.compile("\\w\\.");

    public ShowAddListeners() {
        name.addActionListener(e -> {
            String nm = name.getText().trim();
            if (StringUtils.isEmpty(nm)) {
                results.setText("No match");
                return;
            }

            Class<?> kind;
            try {
                kind = Class.forName("javax.swing." + nm);
            } catch (ClassNotFoundException ex) {
                results.setText("No match");
                return;
            }

            Method[] methods = kind.getMethods();
            results.setText("");
            Arrays.stream(methods).forEach(m -> {
                Matcher matcher = addListener.matcher(m.toString());
                if (matcher.find()) {
//                    results.append(qualifier.matcher(
//                            matcher.group(1)).replaceAll("") + "\n"
//                    );
                    results.append(matcher.group(1)+ "\n");
                }
            });
        });

        JPanel top = new JPanel();
        top.add(new Label("Swing class name (press Enter):"));
        top.add(name);

        add(BorderLayout.NORTH, top);
        add(new JScrollPane(results));
        name.setText("JTextArea");

        ActionListener[] actionListeners = name.getActionListeners();
        ActionListener nameListener = actionListeners[0];
        nameListener.actionPerformed(new ActionEvent("", 0, ""));
    }

    public static void main(String[] args) {
        SwingConsole.run(new ShowAddListeners(), 500, 400);
    }
}

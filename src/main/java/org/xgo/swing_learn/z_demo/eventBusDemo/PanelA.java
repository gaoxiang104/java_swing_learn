package org.xgo.swing_learn.z_demo.eventBusDemo;

import javax.swing.*;
import java.awt.*;

public class PanelA extends JPanel {
    private PanelA1 panelA1;
    private PanelA2 panelA2;

    public PanelA() {
        initializeUI();
    }

    private void initializeUI() {
        setBorder(BorderFactory.createTitledBorder("PanelA容器"));
        setLayout(new GridLayout(2, 1));

        panelA1 = new PanelA1();
        add(panelA1);

        panelA2 = new PanelA2();
        add(panelA2);
    }
}

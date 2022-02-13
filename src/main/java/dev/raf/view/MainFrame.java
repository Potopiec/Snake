package dev.raf.view;

import dev.raf.main;

import javax.swing.*;

public class MainFrame extends JFrame {

    JComponent component;

    public MainFrame(JComponent component){
        super();

        this.component = component;
        this.setName(main.TITLE);
        this.setSize(((main.MAP_WIDTH-2)*main.MAP_CELLS+12),((main.MAP_HEIGHT-2)*main.MAP_CELLS+35));
        this.setResizable(false);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(component);

        this.setVisible(true);
    }
}

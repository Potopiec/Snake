package dev.raf;


import dev.raf.engine.GameControlls;
import dev.raf.engine.GameThread;
import dev.raf.view.GameWorld;
import dev.raf.view.MainFrame;

import javax.swing.*;

public class main {
    public final static String TITLE = "Snake";
    public final static int MAP_CELLS = 20;
    public final static int MAP_HEIGHT = 65;
    public final static int MAP_WIDTH = 110;


    public static void main(String[] args) {

        GameControlls gameControlls = new GameControlls();
        GameWorld component = new GameWorld(gameControlls);
        component.createWorld();


        new GameThread(component);

        JFrame frame = new MainFrame(component);

        frame.addKeyListener(gameControlls);



    }
}

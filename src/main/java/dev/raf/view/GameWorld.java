package dev.raf.view;

import dev.raf.commonInterfaces.Tickable;
import dev.raf.engine.GameControlls;

import dev.raf.gameElements.ElementsFactory;
import dev.raf.gameElements.MapElement;
import dev.raf.gameElements.MapElementsGenerator;
import dev.raf.gameElements.Snake;
import dev.raf.main;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.*;


public class GameWorld extends JComponent implements Tickable {


   private GameControlls gameControlls;
   private Snake snake;

   private int map[][];


    public GameWorld( GameControlls gameControlls){
        super();
        this.gameControlls = gameControlls;
    }

    public void createWorld(){
        map = MapElementsGenerator.generateMap(); 
        snake = new Snake(map,(int) (main.MAP_HEIGHT/2),(int) (main.MAP_WIDTH/2),gameControlls);
        snake.setUpSnake();
        MapElementsGenerator.populateWithEatables(map);


    }



    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        
        if(!snake.isUpdating()) {

        for (int i = 0; i<map.length;i++){
            for (int j = 0; j<map[0].length;j++){
                if (map[i][j] != 0)
                    ElementsFactory.getElement(map[i][j],i,j).render(g2);
            }
        }
        } 

        repaint();
        
    }

    @Override
    public void tick() {
        snake.tick();

    }
}

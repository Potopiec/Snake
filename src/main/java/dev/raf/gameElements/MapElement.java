package dev.raf.gameElements;

import dev.raf.main;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MapElement {

    private Color color;
    private Rectangle2D.Float body;
    public MapElement(int posX,int posY,Color color){
        this.color = color;
        body = new Rectangle2D.Float(posX*main.MAP_CELLS,posY*main.MAP_CELLS,main.MAP_CELLS,main.MAP_CELLS);
    }


    public void render(Graphics2D g){

        g.setColor(color);
        g.fill(body);
    }
}

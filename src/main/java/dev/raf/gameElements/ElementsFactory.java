package dev.raf.gameElements;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ElementsFactory {
    public static MapElement getElement(int i,int posX,int posY){

        Color c = Color.BLACK;
        switch (i){
            case 1:
                c= Color.GREEN;
                break;
            case 2:
                c= Color.magenta;
                break;
            case 3:
                c= Color.yellow;
                break;
            case 4:
                c= Color.cyan;
                break;
        }

        return new MapElement(posX, posY,c);
    }
}

package dev.raf.gameElements;

import dev.raf.main;

import java.util.Random;

public class MapElementsGenerator{


    public static int[][] generateMap(){
        return new int[main.MAP_WIDTH][main.MAP_HEIGHT];
    }
    public static void populateWithEatables(int[][] map){
        int mapHeight = main.MAP_HEIGHT;
        int mapWidth = main.MAP_WIDTH;

        int posY;
        int posX;
        do {
            posY = new Random().nextInt(mapHeight);
            posX = new Random().nextInt(mapWidth);
        }while(checkGameFieldAvailability(map,posX,posY));

        map[posX][posY] = insertRandomField();

    }

    private static boolean checkGameFieldAvailability(int[][] map,int posX,int posY){
        if (map[posX][posY] == 0)
            return false;
        return true;
    }

    //TODO set random number for sprites (2 is a placeholder)
    private static int insertRandomField(){
        return 4;
    }






}

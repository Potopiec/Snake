package dev.raf.gameElements;

import java.awt.Point;
import java.util.ArrayList;

import dev.raf.engine.Controller;
import dev.raf.engine.MovingDirections;


public class Snake {

    private int XDirection, YDirection;
    private int elementCode = 1;
    private int snakeSize = 1;
    private int posX, posY;
    private int previousPosX,previousPosY;
    private int[][] map;
    private ArrayList<Point> snakeShape;
    private Controller controller;
    private boolean updating;
    public Snake(int[][] map, int posX, int posY, Controller controller){
        this.map = map;
        this.posX = posX;
        this.posY = posY;
        this.controller = controller;
        
        

    }

    public void setUpSnake(){
        map[posY][posX] = elementCode;
        snakeShape = new ArrayList<>();
        snakeShape.add(new Point(posY,posX));
    }

    public void tick() {
    	
    	updating = true;

        if (controller!= null) {
            move(controller.getMovingDirection());
            updateSnakeShape();
            }
        
        
        updating = false;

    }

    private void resetDirections(){
        XDirection = 0;
        YDirection = 0;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void move(MovingDirections direction) {
        if ((controller != null)&&(controller.isFirstClick())){

            switch (direction){
                case TOP:
                    if (XDirection == 0){
                        resetDirections();
                        XDirection = (-1);
                    }
                    break;
                case DOWN:
                    if (XDirection == 0){
                        resetDirections();
                        XDirection = (1);
                    }
                    break;
                case LEFT:
                    if (YDirection == 0) {
                        resetDirections();
                        YDirection = (-1);
                    }
                    break;
                case RIGHT:
                    if (YDirection == 0){
                        resetDirections();
                        YDirection = (1);
                    }
                    break;
            }

            previousPosX = posX;
            previousPosY = posY;

            posY +=YDirection;
            posX +=XDirection;

            if (map[posY][posX] != 0)
                hit();

            map[posY][posX] = elementCode;
            map[previousPosY][previousPosX] = 0;
            snakeShape.get(0).setLocation(posY, posX);
        }
    }
    
    
    public void updateSnakeShape(){
    	Point previousPoint = null;
    	
    
    		for(int i = 0; i<snakeShape.size();i++ ) {
    			if(i == 0) {
    				previousPoint = new Point(previousPosY,previousPosX);
    			}else {
    			
    			Point nextPoint = new Point(snakeShape.get(i).x, snakeShape.get(i).y);
    			
    			if (i > 0) {
        			snakeShape.set(i, new Point(previousPoint));
        			}
    			
    			previousPoint.setLocation(nextPoint);
    			
    			}
    			
    			
    		}
    		
    		
		map[previousPoint.x][previousPoint.y] = 0;
			
    	if(snakeShape.size() < snakeSize) {
    		snakeShape.add(new Point(previousPoint));
    		
    	}
    	
    	putSnakeOnMap();
    	
    }
    
    private void putSnakeOnMap() {
    for(Point p:snakeShape) {
    	map[p.x][p.y] = elementCode;
    }	
    	
    }
    

    private void hit(){
        MapElementsGenerator.populateWithEatables(map);
        snakeSize++;
      
        System.out.println(snakeSize);

    }
    
    public boolean isUpdating() {
    	return updating;
    }
    
    public ArrayList<Point> getSnakeBody(){
    	return snakeShape;
    	
    }


}

package dev.raf.gameElements;

import java.awt.Point;
import java.util.ArrayList;

import dev.raf.main;
import dev.raf.engine.Controller;
import dev.raf.engine.MovingDirections;


public class Snake {

    private int XDirection, YDirection;
    private int elementCode = 1;
    private int snakeSize = 1;
    private int posX, posY;
    private int previousPosX,previousPosY;
    private int[][] map;
    private ArrayList<Point> snakeBody;
    private Controller controller;
    private boolean updating;
    private boolean sneakIsDead;
    
    
    public Snake(int[][] map, int posX, int posY, Controller controller){
        this.map = map;
        this.posX = posX;
        this.posY = posY;
        this.controller = controller;
        
        

    }

    public void setUpSnake(){
        map[posY][posX] = elementCode;
        snakeBody = new ArrayList<>();
        snakeBody.add(new Point(posY,posX));
    }

    public void tick() {
    	
    	updating = true;

        if (controller!= null) {
        	moveSnakesHead(controller.getMovingDirection());
            updateSnakeBody();
            }
        
        
        updating = false;

    }

    private void resetDirections(){
        XDirection = 0;
        YDirection = 0;
    }

    

    public void moveSnakesHead(MovingDirections direction) {
        if ((controller != null)&&(controller.isFirstClick())&&(!sneakIsDead)){

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

            hitBox(posX,posY);

            map[posY][posX] = elementCode;
            snakeBody.get(0).setLocation(posY, posX);
        }
    }
    
    
    private void hitBox(int x,int y) {
    	
    	if(isInsideGameMap(x,y)) {
    		sneakIsDead = true;
    	};
    	
    	if (map[posY][posX] != 0)
            hit();
    	
    }
    
    private boolean isInsideGameMap(int x,int y) {
    	
    	if(((x > 0)&&(x<main.MAP_HEIGHT-1))&&((y>0)&&(y<main.MAP_WIDTH-1))) {
    		return false;
    		
    	}else {
    		return true;
    		
    	}
    	
    	
    }
    
    
    public void updateSnakeBody(){
    	Point previousPoint = null;
    		
    	for(int i = 0; i<snakeBody.size();i++ ) {
    			if(i == 0) {
    				previousPoint = new Point(previousPosY,previousPosX);
    			}else {
    			
    			Point nextPoint = new Point(snakeBody.get(i).x, snakeBody.get(i).y);
    			
    			if (i > 0) {
    				snakeBody.set(i, new Point(previousPoint));
        			}
    			
    			previousPoint.setLocation(nextPoint);
    			
    			}	
    		}
    		
    		
    	cleanAfterSnake(previousPoint);
		
    	growTheSnake(previousPoint);
    	
    	putSnakeOnMap();
    	
    }
    
    private void putSnakeOnMap() {
    for(Point p:snakeBody) {
    	map[p.x][p.y] = elementCode;
    	}	
    }
    

    private void hit(){
        MapElementsGenerator.populateWithEatables(map);
        snakeSize++;
        }
    
    private void cleanAfterSnake(Point point) {
    	map[point.x][point.y] = 0;
    }
    
    private void growTheSnake(Point point) {
    	if(snakeBody.size() < snakeSize) {
    		snakeBody.add(new Point(point));
    		
    	}
    }
    
   
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public boolean isUpdating() {
    	return updating;
    }
    
    public ArrayList<Point> getSnakeBody(){
    	return snakeBody;
    	
    }
    
    
    


}

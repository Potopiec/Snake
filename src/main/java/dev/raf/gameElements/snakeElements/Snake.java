package dev.raf.gameElements.snakeElements;

import java.util.ArrayList;

import dev.raf.main;
import dev.raf.engine.Controller;
import dev.raf.engine.MovingDirections;

public class Snake extends SnakeBodyElement {
	
	private int XDirection, YDirection;
	private ArrayList<SnakeBodyElement> snakeBody;
	private Controller controller;
	private boolean snakeIsDead;

	public Snake(int posX, int posY,Controller controller) {
		super(posX, posY);
		this.controller = controller;
		snakeBody = new ArrayList<>();
		snakeBody.add(this);
		
	}
	
		
	
	protected void updatePosition() {
        if ((controller != null)&&(controller.isFirstClick())&&(!snakeIsDead)){
        	MovingDirections direction = controller.getMovingDirection();
            
        	switch (direction){
                case TOP:
                    if (YDirection == 0){
                        resetDirections();
                        YDirection = (-1);
                    }
                    break;
                case DOWN:
                    if (YDirection == 0){
                        resetDirections();
                        YDirection = (1);
                    }
                    break;
                case LEFT:
                    if (XDirection == 0) {
                        resetDirections();
                        XDirection = (-1);
                    }
                    break;
                case RIGHT:
                    if (XDirection == 0){
                        resetDirections();
                        XDirection = (1);
                    }
                    break;
            }

            previousPosX = posX;
            previousPosY = posY;

            posY += (YDirection*main.MAP_CELLS);
            posX += (XDirection*main.MAP_CELLS);
            
            
            
            body.x = posX;
            body.y = posY;

            //hitBox(posX,posY);

            
           
        }
    }
	
	 private void resetDirections(){
	        XDirection = 0;
	        YDirection = 0;
	    }
	
	
	
	
	public ArrayList<SnakeBodyElement> getSnakeBody(){
		return snakeBody;
	}

}

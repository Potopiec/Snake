package dev.raf.gameElements.snakeElements;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import dev.raf.main;
import dev.raf.commonInterfaces.IRenderable;
import dev.raf.commonInterfaces.ITickable;

public class SnakeBodyElement implements ITickable,IRenderable {
	protected int posX, posY;
	protected int previousPosX,previousPosY;
	protected SnakeBodyElement parent, child;
	protected enum direction {leftTop,rightTop,downLeft,downRight,straightTop,straightSides}
	protected Rectangle2D.Float body;
	
	public SnakeBodyElement(int posX,int posY,SnakeBodyElement parent) {
		this(posX,posY);
		this.parent = parent;
		
	}
	
	public SnakeBodyElement(int posX,int posY) {
		this.posX = posX;
		this.posY = posY;
		this.parent = null;
		this.child = null;
		
		body = new Rectangle2D.Float(posX,posY,main.MAP_CELLS,main.MAP_CELLS);
	}
	
	@Override
	public void tick() {
		
		updatePosition();
		
		
		
	}
	
	@Override
	public void render(Graphics2D g) {
		
		g.fill(body);
	}
	
	
	protected void updatePosition() {
			
	}
	
	
	
	

}

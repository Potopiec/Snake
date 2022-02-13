package dev.raf.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameControlls implements KeyListener ,Controller {

    private boolean firstClick;
    private MovingDirections movingDirections;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!firstClick)
            firstClick = true;

        if (e.getKeyCode() == KeyEvent.VK_UP){
            movingDirections = MovingDirections.TOP;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            movingDirections = MovingDirections.DOWN;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            movingDirections = MovingDirections.LEFT;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            movingDirections = MovingDirections.RIGHT;
        }
    }



    @Override
    public MovingDirections getMovingDirection() {
        return movingDirections;
    }

    @Override
    public boolean isFirstClick() {
        return firstClick;
    }
}

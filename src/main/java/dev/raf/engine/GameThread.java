package dev.raf.engine;


import dev.raf.commonInterfaces.ITickable;

public class GameThread extends Thread {

    private ITickable tickable;

    public GameThread(ITickable tickable){
        this.tickable = tickable;
        this.start();
    }



    public void run(){
        while (true){
            tickable.tick();


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    };


}

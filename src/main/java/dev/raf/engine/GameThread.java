package dev.raf.engine;


import dev.raf.commonInterfaces.Tickable;

public class GameThread extends Thread {

    private Tickable tickable;

    public GameThread(Tickable tickable){
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

package com.cursor.krasulia.hw11.ping_pong;

public class PingPongGame {

    private volatile boolean flag;

    private long gameTime;

    public PingPongGame() {
    }

    public PingPongGame(long gameTime) {
        this.gameTime = gameTime;
    }

    public synchronized void sayPing() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Ping");
        flag = true;
        notifyAll();
    }

    public long getGameTime() {
        return gameTime;
    }
}

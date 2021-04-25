package com.cursor.krasulia.hw11.ping_pong;

public class PingPongGame {

    private volatile boolean flag;

    private long gameTime;

    public PingPongGame() {
    }

    public synchronized void sayPong() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("\tPong");
        flag = false;
        notifyAll();
    }

}

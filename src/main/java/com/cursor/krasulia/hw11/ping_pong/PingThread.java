package com.cursor.krasulia.hw11.ping_pong;

public class PingThread implements Runnable {
    private PingPongGame game;

    public PingThread(PingPongGame game) {
        this.game = game;
    }

    @Override
    public void run() {
        for (int i = 0; i < game.getGameTime(); i++) {
            game.sayPing();
        }
    }
}

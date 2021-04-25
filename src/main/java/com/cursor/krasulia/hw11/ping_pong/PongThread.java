package com.cursor.krasulia.hw11.ping_pong;

public class PongThread implements Runnable {
    private PingPongGame game;

    public PongThread(PingPongGame game) {
        this.game = game;
    }

    @Override
    public void run() {
        for (int i = 0; i < game.getGameTime(); i++) {
            game.sayPong();
        }
    }
}

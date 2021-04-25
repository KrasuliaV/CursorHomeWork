package com.cursor.krasulia.hw11.ping_pong;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Enter game duration number");
        long durationNumber = Long.parseLong(AnswerChecker.checkAnswer(new Scanner(System.in).next()));
        PingPongGame pingPongGame = new PingPongGame(durationNumber);
        Thread threadPing = new Thread(new PingThread(pingPongGame));
        Thread threadPong = new Thread(new PongThread(pingPongGame));
        threadPing.start();
        threadPong.start();
        threadPing.join();
        threadPong.join();
        System.out.println("Game over!!! Ha-ha");
    }
}

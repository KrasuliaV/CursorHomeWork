package com.cursor.krasulia.hw13.task1;

public class EggThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Egg");
        }
    }
}

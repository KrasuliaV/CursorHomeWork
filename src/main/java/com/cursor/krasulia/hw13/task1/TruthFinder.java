package com.cursor.krasulia.hw13.task1;

public class TruthFinder {

    public static void main(String[] args) {
        Thread eggThread = new Thread(new EggThread());
        eggThread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Chicken");
        }

        if (eggThread.isAlive()) {
            try {
                eggThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Egg was first");
        } else {
            System.out.println("Chicken was first");
        }
    }
}

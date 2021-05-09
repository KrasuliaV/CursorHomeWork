package com.cursor.krasulia.hw13.task2;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class DiningRoom {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Philosopher> philosophers = List.of(new Philosopher("Misha", semaphore),
                new Philosopher("Kesha", semaphore),
                new Philosopher("Gesha", semaphore),
                new Philosopher("Tosha", semaphore),
                new Philosopher("Tasha", semaphore));

        System.out.println("The dining room opens up");
        for (int i = 0; i < philosophers.size(); i++) {
            executor.execute(philosophers.get(i));
        }
        executor.shutdown();
    }
}

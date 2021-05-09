package com.cursor.krasulia.hw13.task2;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private final String name;
    private Semaphore semaphore;

    public Philosopher(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.printf("The philosopher %s from %s  came to the kitchen%n", name, Thread.currentThread().getName());
            semaphore.acquire();
            System.out.printf("The philosopher %s from %s is starting to eat his bread and water%n", name, Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.printf("The philosopher %s from %s finished eating%n", name, Thread.currentThread().getName());
            System.out.printf("The philosopher %s from %s leaves the kitchen%n", name, Thread.currentThread().getName());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

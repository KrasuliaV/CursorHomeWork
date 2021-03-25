package com.cursor.krasulia.hw2.task5;

public class Money {
    private long hryvnia;
    private byte coin;

    public Money(long hryvnia, byte coin) {
        if (hryvnia < 0 || coin < 0) {
            System.out.println("Money can't be less then 0!!!");
            this.hryvnia = 0;
            this.coin = 0;
        } else {
            this.hryvnia = hryvnia;
            this.coin = coin;
        }
    }

    public long getHryvnia() {
        return hryvnia;
    }

    public short getCoin() {
        return coin;
    }

    @Override
    public String toString() {
        return hryvnia + "," + coin;
    }
}

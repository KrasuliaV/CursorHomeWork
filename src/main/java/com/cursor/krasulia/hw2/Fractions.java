package com.cursor.krasulia.hw2;

public class Fractions {
    private long fullPart;
    private short fractionalPart;

    public Fractions(long fullPart, short fractionalPart) {
        this.fullPart = fullPart;
        this.fractionalPart = fractionalPart;
    }

    public long getFullPart() {
        return fullPart;
    }

    public short getFractionalPart() {
        return fractionalPart;
    }
}

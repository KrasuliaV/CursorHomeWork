package com.cursor.krasulia.hw2.task4;

public class Fractions {

    private final long fullPart;
    private final short fractionalPart;

    public Fractions(long fullPart, short fractionalPart) {
        if (fractionalPart == 0) {
            throw new IllegalArgumentException("The fractional part can't be zero");
        } else if (fullPart == 0) {
            this.fullPart = 0;
            this.fractionalPart = 1;
        } else if (fractionalPart < 0) {
            this.fullPart = -fullPart;
            this.fractionalPart = (short) -fractionalPart;
        } else {
            this.fullPart = fullPart;
            this.fractionalPart = fractionalPart;
        }
    }

    public long getFullPart() {
        return fullPart;
    }

    public short getFractionalPart() {
        return fractionalPart;
    }

    @Override
    public String toString() {
        if (fractionalPart != 1) {
            return fullPart + "/" + fractionalPart;
        } else {
            return fullPart + "";
        }
    }
}

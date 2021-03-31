package com.cursor.krasulia.hw4.task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class GenericComparableArray<T extends Comparable<T>> {
    private T[] array;

    public GenericComparableArray(T[] array) {
        this.array = array;
    }

    public T largest() {
        return Arrays.stream(array)
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public T smallest() {
        return Arrays.stream(array)
                .sorted()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    @Override
    public String toString() {
        return "GenericComparableArray{" + Arrays.toString(array) +
                '}';
    }
}

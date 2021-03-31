package com.cursor.krasulia.hw4.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyComparableList<T extends Comparable<T>> {
    private final List<T> list;

    public MyComparableList() {
        list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public T largest() {
        return list.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public T smallest() {
        return list.stream()
                .sorted()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    @Override
    public String toString() {
        return "MyComparableList{" + list +
                '}';
    }
}

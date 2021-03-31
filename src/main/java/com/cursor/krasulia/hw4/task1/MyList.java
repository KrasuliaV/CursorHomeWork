package com.cursor.krasulia.hw4.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class MyList<T extends Number> {
    private final List<T> list;

    public MyList() {
        list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public T largest() {
        return list.stream()
                .min(Collections.reverseOrder())
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
        return "MyList{" + list +
                '}';
    }
}

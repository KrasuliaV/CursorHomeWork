package com.cursor.krasulia.hw5.task1;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class SinglyLinkedList<E> {
    private int size;
    private E[] elements;

    public SinglyLinkedList(int initialCapacity) {
        this.elements = (E[]) new Object[initialCapacity];
    }

    public SinglyLinkedList() {
        this(10);
    }

//    Methods: push, pop,top, size, isEmpty,

    public E push(E element) {
        if (size == elements.length - 1) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size] = element;
        size++;
        return element;
    }

    public E pop() {
        if (size == 0) throw new EmptyStackException();
        E element = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return element;
    }

    public E top() {
        if (size == 0) throw new EmptyStackException();
        return elements[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SinglyLinkedList{ ");
        if (size == 0) return sb.toString() + " }";
        Arrays.stream(elements)
                .filter(Objects::nonNull)
                .forEach(el -> sb.append(el).append(", "));
        return sb.substring(0, sb.length() - 2) + " }";
    }
}

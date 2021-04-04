package com.cursor.krasulia.hw5.task2;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

    private int size = 0;

    private Node<E> first;
    private Node<E> last;

    private class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void enqueue(E element) {
        if (size == 0) {
            last = new Node<>(element, null, last);
            first = last;
        }
        last.next = new Node<>(element, null, last);
        last = last.next;
        size++;
    }

    public void dequeue() {
        if (size == 0) throw new NoSuchElementException();
        else if (size == 1) {
            first = null;
            last = null;
            size--;
        } else {
            first = first.next;
            first.prev = null;
            size--;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DoublyLinkedList{ ");
        if (size == 0) return sb.toString() + " }";
        Node<E> nextNode = first;
        sb.append(first.element);
        while (nextNode.next != null) {
            nextNode = nextNode.next;
            sb.append(", ").append(nextNode.element);
        }
        return sb.append(" }").toString();
    }
}

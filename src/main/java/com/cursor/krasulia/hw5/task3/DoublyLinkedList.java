package com.cursor.krasulia.hw5.task3;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    private class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, Node<E> next, E element) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(null, first, element);
        if (size > 0) {
            first.prev = newNode;
        }
        first = newNode;
        if (size == 0) last = first;
        size++;
    }

    public void addLast(E element) {
        if (size == 0) {
            last = new Node<>(last, null, element);
            first = last;
        }
        last.next = new Node<>(last, null, element);
        last = last.next;
        size++;
    }

    public void add(int index, E element) {
        if (index > size || index < 0) throw new NullPointerException();
        else if (index == 0) addFirst(element);
        else if (index == size) addLast(element);
        else {
            Node<E> node = findNodeByIndex(index);
            Node<E> newNode = new Node<>(node.prev, node, element);
            node.prev.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    private Node<E> findNodeByIndex(int index) {
        Node<E> nextNode;
        if (index <= size / 2) {
            nextNode = first;
            for (int pointer = 1; pointer <= index; pointer++) {
                nextNode = nextNode.next;
            }
        } else {
            nextNode = last;
            for (int pointer = size - 1; pointer > index; pointer--) {
                nextNode = nextNode.prev;
            }
        }
        return nextNode;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void removeFirst() {
        removeMarginal(true);
    }

    public void removeLast() {
        removeMarginal(false);
    }

    private void removeMarginal(boolean isFirst) {
        if (size == 0) throw new NoSuchElementException();
        else if (size == 1) {
            first = null;
            last = null;
            size--;
        } else {
            if (isFirst) {
                first = first.next;
                first.prev = null;
            } else {
                last = last.prev;
                last.next = null;
            }
            size--;
        }
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

package com.cursor.krasulia.hw5.task2;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList<String> newList = new DoublyLinkedList<>();
        System.out.println("List size before adding: " + newList.size());
        System.out.println("List before adding:\n" + newList);
        newList.enqueue("first");
        newList.enqueue("second");
        newList.enqueue("third");
        newList.enqueue("forth");
        newList.enqueue("first Last");
        newList.enqueue("second Last");
        System.out.println("List size after adding: " + newList.size());
        System.out.println("List after adding :\n" + newList);
        newList.dequeue();
        newList.dequeue();
        System.out.println("List size after removing: " + newList.size());
        System.out.println("List after removing :\n" + newList);

    }
}

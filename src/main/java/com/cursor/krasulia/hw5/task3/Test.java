package com.cursor.krasulia.hw5.task3;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList<String> newList = new DoublyLinkedList<>();
        System.out.println("List size before adding: " + newList.size());
        System.out.println("List before adding:\n" + newList);
        newList.addFirst("first");
        newList.addFirst("second");
        newList.addFirst("third");
        newList.addFirst("forth");
        newList.addLast("first Last");
        newList.addLast("second Last");
        newList.add(3, "new Add");
        System.out.println("List size after adding: " + newList.size());
        System.out.println("List after adding :\n" + newList);
        newList.removeFirst();
        newList.removeLast();
        System.out.println("List size after removing: " + newList.size());
        System.out.println("List after removing :\n" + newList);
    }
}

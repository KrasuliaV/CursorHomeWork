package com.cursor.krasulia.hw5.task1;

import java.util.EmptyStackException;

public class Test {
    public static void main(String[] args) {
        SinglyLinkedList<String> mySinglyLinkedList = new SinglyLinkedList<>(1);
        System.out.println("SinglyLinkedList size is: " + mySinglyLinkedList.size());
        System.out.println(mySinglyLinkedList.push("First push element"));
//        System.out.println(mySinglyLinkedList.push("Second push element"));
//        System.out.println(mySinglyLinkedList.push("Third push element"));
//        System.out.println(mySinglyLinkedList.push("Forth push element"));
        System.out.println("SinglyLinkedList size is: " + mySinglyLinkedList.size());
        System.out.println(mySinglyLinkedList.pop());
        try {
            System.out.println(mySinglyLinkedList.pop());
        } catch (EmptyStackException exception) {
            System.out.println("Stack is Empty");
        }
        System.out.println("SinglyLinkedList size is: " + mySinglyLinkedList.size());
        System.out.println(mySinglyLinkedList);
        System.out.println("Top element is: " + mySinglyLinkedList.top());

    }
}

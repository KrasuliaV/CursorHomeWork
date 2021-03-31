package com.cursor.krasulia.hw4.task2;

public class Test {
    public static void main(String[] args) {
        MyComparableList<Integer> listInteger = new MyComparableList<>();
        listInteger.add(4);
        listInteger.add(-9);
        listInteger.add(8);
        System.out.println(listInteger);
        System.out.println("Largest element: " + listInteger.largest());
        System.out.println("Smallest element: " + listInteger.smallest());
        MyComparableList<String> listString = new MyComparableList<>();
        listString.add("4.00");
        listString.add("-99997.07");
        listString.add("Double");
        System.out.println(listString);
        System.out.println("Largest element: " + listString.largest());
        System.out.println("Smallest element: " + listString.smallest());
    }
}

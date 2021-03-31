package com.cursor.krasulia.hw4.task3;

public class Test {
    public static void main(String[] args) {
        Integer[] arrayInt = new Integer[]{4, -9, 8};
        GenericComparableArray<Integer> listInteger = new GenericComparableArray<>(arrayInt);
        System.out.println(listInteger);
        System.out.println("Largest element: " + listInteger.largest());
        System.out.println("Smallest element: " + listInteger.smallest());
        String[] arrayStr = new String[]{"First element", "Second element", "Third element"};
        GenericComparableArray<String> listString = new GenericComparableArray<>(arrayStr);
        System.out.println(listString);
        System.out.println("Largest element: " + listString.largest());
        System.out.println("Smallest element: " + listString.smallest());
    }
}

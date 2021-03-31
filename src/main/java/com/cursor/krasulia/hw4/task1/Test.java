package com.cursor.krasulia.hw4.task1;

public class Test {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(4);
        listInteger.add(-9);
        listInteger.add(8);
        System.out.println(listInteger);
        System.out.println("Largest element: " + listInteger.largest());
        System.out.println("Smallest element: " + listInteger.smallest());
        MyList<Double> listDouble = new MyList<>();
        listDouble.add(4.00);
        listDouble.add(-99997.07);
        listDouble.add(59.87);
        System.out.println(listDouble);
        System.out.println("Largest element: " + listDouble.largest());
        System.out.println("Smallest element: " + listDouble.smallest());
    }
}

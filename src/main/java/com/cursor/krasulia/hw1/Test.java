package com.cursor.krasulia.hw1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        /*2.Create next array of Integers with values: 2,3,1,7,11. Sort them by DESC(reverseOrder).*/
        Integer[] arr = {2, 3, 1, 7, 11};
        System.out.println("Sorted array by DESC " + Arrays.toString(HomeWorkClass.sortDESCArray(arr)));

        /*3.You get an array of numbers(should contain both positive and negative numbers),
        and return the sum of all the positive ones. (If there are nothing to sum, sum should be 0)*/
        Integer[] arr2 = {2, -3, 1, -7, 11};
        System.out.println("Sum of all the positive numbers: " + HomeWorkClass.sumPositiveNumber(arr2));

        /*4.You get an array of numbers, return the average of a list of numbers in this array.
        (Example -  array{1,2,4,1} -> avg = 2)*/
        int[] arr3 = {1, 2, 4, 1};
        System.out.println("Average number in this array: " + HomeWorkClass.average(arr3));

        /*5.You have array {3,2,3,1,4,2,8,3}.
        Replace all duplicated values by 0. Result should be  next: {3,2,0,1,4,0,8,0}*/
        int[] arr4 = {3, 2, 3, 1, 4, 2, 8, 3};
        System.out.println("Array without duplicate: " + Arrays.toString(HomeWorkClass.replaceDuplicate(arr4)));
    }
}

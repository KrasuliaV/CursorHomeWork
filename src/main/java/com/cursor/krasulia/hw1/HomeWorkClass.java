package com.cursor.krasulia.hw1;

import java.util.Arrays;
import java.util.Collections;

public class HomeWorkClass {
    /* 1.Why arrays in java initialize with fixed size and can’t be dynamic?

    Cause it's special container to hold only constant number of values of the same type
    And memory space is allocated only for constant number of values of a particular type */

    /*2.Create next array of Integers with values: 2,3,1,7,11. Sort them by DESC(reverseOrder).*/
    public static Integer[] sortDESCArray(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        return arr;
    }

    /*3.You get an array of numbers(should contain both positive and negative numbers),
    and return the sum of all the positive ones. (If there are nothing to sum, sum should be 0)*/
    public static int sumPositiveNumber(Integer[] arr) {
        return Arrays.stream(arr)
                .filter(x -> x >= 0)
                .reduce(0, Integer::sum);
    }

    /*4.You get an array of numbers, return the average of a list of numbers in this array.
    (Example -  array{1,2,4,1} -> avg = 2)*/
    public static double average(int[] arr) {
        return Arrays.stream(arr)
                .average()
                .orElse(0.0);
    }

    /*4.You have array {3,2,3,1,4,2,8,3}.
    Replace all duplicated values by 0. Result should be  next: {3,2,0,1,4,0,8,0}*/
    public static int[] replaceDuplicate(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) arr[j] = 0;
            }
        }
        return arr;
    }

}

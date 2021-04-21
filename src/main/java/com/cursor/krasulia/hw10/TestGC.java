package com.cursor.krasulia.hw10;

public class TestGC {

    /**
     * Configuration:
     * -verbose:gc
     * -Xmx124m
     * -Xlog:gc=debug:file=gc.txt
     */
    private static Long[] arr = new Long[20_000_000];

    public static void main(String[] args) {
        System.out.println("Start program");
        for (int i = 0; i > -1; i++) {
            arr[i] = new Long(i);
        }
    }
}

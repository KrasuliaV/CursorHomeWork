package com.cursor.krasulia.hw12.task2;

import java.util.List;

public class Test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        new PercentFinder().displayPercentOfUniqueNumbers(List.of(1, 1),
                List.of(1, 2, 2, 3),
                List.of(1, 2, 3, 4),
                List.of(1, 1, 1, 1, 1));

        new PercentFinder().startUniqueNumberPercentFinder();
    }
}

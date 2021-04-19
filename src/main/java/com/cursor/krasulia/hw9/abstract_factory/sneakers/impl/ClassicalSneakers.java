package com.cursor.krasulia.hw9.abstract_factory.sneakers.impl;

import com.cursor.krasulia.hw9.abstract_factory.sneakers.Sneakers;

public class ClassicalSneakers implements Sneakers {

    @Override
    public void saySomething() {
        System.out.println("I'm just sneakers");
    }
}

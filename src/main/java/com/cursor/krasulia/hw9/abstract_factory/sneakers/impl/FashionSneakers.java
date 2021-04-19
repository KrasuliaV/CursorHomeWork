package com.cursor.krasulia.hw9.abstract_factory.sneakers.impl;

import com.cursor.krasulia.hw9.abstract_factory.sneakers.Sneakers;

public class FashionSneakers implements Sneakers {

    @Override
    public void saySomething() {
        System.out.println("I'm fashion sneakers");
    }
}

package com.cursor.krasulia.hw9.abstract_factory.t_short.impl;

import com.cursor.krasulia.hw9.abstract_factory.t_short.TShirt;

public class RunningTShirt implements TShirt {
    @Override
    public void saySomething() {
        System.out.println("I'm very sporty T-Shirt");
    }
}

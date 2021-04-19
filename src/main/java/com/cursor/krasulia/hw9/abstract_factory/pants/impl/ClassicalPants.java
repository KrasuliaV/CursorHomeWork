package com.cursor.krasulia.hw9.abstract_factory.pants.impl;

import com.cursor.krasulia.hw9.abstract_factory.pants.Pants;

public class ClassicalPants implements Pants {

    @Override
    public void saySomething() {
        System.out.println("I'm just classical pants");
    }
}

package com.cursor.krasulia.hw9.abstract_factory.pants.impl;

import com.cursor.krasulia.hw9.abstract_factory.pants.Pants;

public class RunningPants implements Pants {

    @Override
    public void saySomething() {
        System.out.println("I'm elastic breathable running pants");
    }
}

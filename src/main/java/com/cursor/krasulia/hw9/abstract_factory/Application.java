package com.cursor.krasulia.hw9.abstract_factory;

import com.cursor.krasulia.hw9.abstract_factory.factory.ClothingFactory;
import com.cursor.krasulia.hw9.abstract_factory.pants.Pants;
import com.cursor.krasulia.hw9.abstract_factory.sneakers.Sneakers;
import com.cursor.krasulia.hw9.abstract_factory.t_short.TShirt;

public class Application {
    private Pants pants;
    private Sneakers sneakers;
    private TShirt tShirt;

    public Application(ClothingFactory factory) {
        this.pants = factory.createPants();
        this.sneakers = factory.createSneakers();
        this.tShirt = factory.createTShirt();
    }

    public void clothingSay() {
        pants.saySomething();
        sneakers.saySomething();
        tShirt.saySomething();
    }
}

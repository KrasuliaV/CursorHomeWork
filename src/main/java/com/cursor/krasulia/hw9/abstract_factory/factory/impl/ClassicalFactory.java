package com.cursor.krasulia.hw9.abstract_factory.factory.impl;

import com.cursor.krasulia.hw9.abstract_factory.factory.ClothingFactory;
import com.cursor.krasulia.hw9.abstract_factory.pants.Pants;
import com.cursor.krasulia.hw9.abstract_factory.pants.impl.ClassicalPants;
import com.cursor.krasulia.hw9.abstract_factory.sneakers.Sneakers;
import com.cursor.krasulia.hw9.abstract_factory.sneakers.impl.ClassicalSneakers;
import com.cursor.krasulia.hw9.abstract_factory.t_short.TShirt;
import com.cursor.krasulia.hw9.abstract_factory.t_short.impl.ClassicalTShirt;

public class ClassicalFactory implements ClothingFactory {
    @Override
    public Pants createPants() {
        return new ClassicalPants();
    }

    @Override
    public Sneakers createSneakers() {
        return new ClassicalSneakers();
    }

    @Override
    public TShirt createTShirt() {
        return new ClassicalTShirt();
    }
}

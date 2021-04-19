package com.cursor.krasulia.hw9.abstract_factory.factory.impl;

import com.cursor.krasulia.hw9.abstract_factory.factory.ClothingFactory;
import com.cursor.krasulia.hw9.abstract_factory.pants.Pants;
import com.cursor.krasulia.hw9.abstract_factory.pants.impl.FashionPants;
import com.cursor.krasulia.hw9.abstract_factory.sneakers.Sneakers;
import com.cursor.krasulia.hw9.abstract_factory.sneakers.impl.FashionSneakers;
import com.cursor.krasulia.hw9.abstract_factory.t_short.TShirt;
import com.cursor.krasulia.hw9.abstract_factory.t_short.impl.FashionTShirt;

public class FashionFactory implements ClothingFactory {
    @Override
    public Pants createPants() {
        return new FashionPants();
    }

    @Override
    public Sneakers createSneakers() {
        return new FashionSneakers();
    }

    @Override
    public TShirt createTShirt() {
        return new FashionTShirt();
    }
}

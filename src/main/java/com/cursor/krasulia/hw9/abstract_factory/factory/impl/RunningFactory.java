package com.cursor.krasulia.hw9.abstract_factory.factory.impl;

import com.cursor.krasulia.hw9.abstract_factory.factory.ClothingFactory;
import com.cursor.krasulia.hw9.abstract_factory.pants.Pants;
import com.cursor.krasulia.hw9.abstract_factory.pants.impl.RunningPants;
import com.cursor.krasulia.hw9.abstract_factory.sneakers.Sneakers;
import com.cursor.krasulia.hw9.abstract_factory.sneakers.impl.RunningSneakers;
import com.cursor.krasulia.hw9.abstract_factory.t_short.TShirt;
import com.cursor.krasulia.hw9.abstract_factory.t_short.impl.RunningTShirt;

public class RunningFactory implements ClothingFactory {
    @Override
    public Pants createPants() {
        return new RunningPants();
    }

    @Override
    public Sneakers createSneakers() {
        return new RunningSneakers();
    }

    @Override
    public TShirt createTShirt() {
        return new RunningTShirt();
    }
}

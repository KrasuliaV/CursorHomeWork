package com.cursor.krasulia.hw9.abstract_factory.factory;

import com.cursor.krasulia.hw9.abstract_factory.pants.Pants;
import com.cursor.krasulia.hw9.abstract_factory.sneakers.Sneakers;
import com.cursor.krasulia.hw9.abstract_factory.t_short.TShirt;

public interface ClothingFactory {
    Pants createPants();

    Sneakers createSneakers();

    TShirt createTShirt();
}

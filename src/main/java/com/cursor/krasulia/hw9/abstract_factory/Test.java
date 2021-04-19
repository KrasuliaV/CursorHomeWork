package com.cursor.krasulia.hw9.abstract_factory;

import com.cursor.krasulia.hw9.abstract_factory.factory.ClothingFactory;
import com.cursor.krasulia.hw9.abstract_factory.factory.impl.ClassicalFactory;
import com.cursor.krasulia.hw9.abstract_factory.factory.impl.FashionFactory;
import com.cursor.krasulia.hw9.abstract_factory.factory.impl.RunningFactory;

public class Test {
    private static Application configureApplication(String clothingType) {
        Application app;
        ClothingFactory factory;
        if (clothingType.equals("run")) {
            return new Application(new RunningFactory());
        } else if (clothingType.equals("fashion")) {
            return new Application(new FashionFactory());
        } else {
            return new Application(new ClassicalFactory());
        }
    }

    public static void main(String[] args) {
        configureApplication("dfviiwaoeidkm").clothingSay();
        System.out.println("Oh my God! I don't want this not cool clothes!!!");
        configureApplication("fashion").clothingSay();
        System.out.println("And now I want cool sport clothes!");
        configureApplication("run").clothingSay();
    }
}

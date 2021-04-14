package com.cursor.krasulia.hw8.task1;

import com.cursor.krasulia.hw8.task1.enteties.Pokeball;
import com.cursor.krasulia.hw8.task1.enteties.Pokemon;
import com.cursor.krasulia.hw8.task1.exception.ExceptionA;
import com.cursor.krasulia.hw8.task1.exception.ExceptionB;
import com.cursor.krasulia.hw8.task1.servise.PokeballUtil;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {

        Pokemon pikachu = Pokemon.PIKACHU;
        Pokeball pokeball = new Pokeball();
        System.out.println("Catch ExeptionB");
        try {
            PokeballUtil.addPokemon(pokeball, null);
        } catch (ExceptionB exceptionB) {
            System.out.println(exceptionB.getMessage());
        } catch (ExceptionA exceptionA) {
            System.out.println(exceptionA.getMessage());
        }

        System.out.println("\nCatch ExeptionA");
        try {
            PokeballUtil.addPokemon(null, pikachu);
        } catch (ExceptionB exceptionB) {
            System.out.println(exceptionB.getMessage());
        } catch (ExceptionA exceptionA) {
            System.out.println(exceptionA.getMessage());
        }

        System.out.println("\nCatch IOException");
        try {
            PokeballUtil.findPokemon("Squirrel");
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

        System.out.println("\nCatch NullPointerException");
        try {
            PokeballUtil.getPokemons(pokeball, 0);
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException.getMessage());
        }

    }
}

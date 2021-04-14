package com.cursor.krasulia.hw8.task1.servise;

import com.cursor.krasulia.hw8.task1.enteties.Pokeball;
import com.cursor.krasulia.hw8.task1.enteties.Pokemon;
import com.cursor.krasulia.hw8.task1.exception.ExceptionA;
import com.cursor.krasulia.hw8.task1.exception.ExceptionB;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class PokeballUtil {

    public static void addPokemon(Pokeball pokeball, Pokemon pokemon) throws ExceptionA {
        if (Optional.ofNullable(pokemon).isPresent()) {
            Optional.ofNullable(pokeball)
                    .orElseThrow(() -> new ExceptionA("You must add right pokeball"))
                    .getPokemonList().add(pokemon);
        } else {
            throw new ExceptionB("You must add right pokemon");
        }
    }

    public static Pokemon findPokemon(String pokemonName) throws IOException {
        if (isThereSuchPokemon(pokemonName)) {
            return Pokemon.valueOf(pokemonName.toUpperCase(Locale.ROOT));
        } else {
            throw new IOException("IOException: You must enter right pokemon name");
        }
    }

    public static List<Pokemon> getPokemons(Pokeball pokeball, int pokemonsNumber) {
        final int pokeballSize = Optional.of(getPokemonsNumber(pokeball.getPokemonList()))
                .orElseThrow(() -> new NullPointerException("NullPointerException: You must add pokemons list"));
        if (pokemonsNumber <= pokeballSize && pokemonsNumber != 0 && pokeballSize != 0) {
            return pokeball.getPokemonList()
                    .stream()
                    .limit(pokemonsNumber)
                    .collect(Collectors.toList());
        } else {
            throw new NullPointerException("NullPointerException: You don't have unough pokemons");
        }
    }

    private static boolean isThereSuchPokemon(String pokemonName) {
        return Arrays.stream(Pokemon.values())
                .map(Enum::toString)
                .anyMatch(someName -> someName.equalsIgnoreCase(pokemonName));
    }

    private static int getPokemonsNumber(List<Pokemon> pokemonList) {
        return Optional.ofNullable(pokemonList)
                .orElseThrow(() -> new NullPointerException("NullPointerExceptionЖ You must add pokemons list"))
                .size();
    }


}

package com.cursor.krasulia.hw8.task1.enteties;

import java.util.ArrayList;
import java.util.List;

public class Pokeball {
    private String ownerName;
    private List<Pokemon> pokemonList;

    public Pokeball() {
        pokemonList = new ArrayList<>();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

}

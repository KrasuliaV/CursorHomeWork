package com.cursor.krasulia.hw7.task1_2;

import static com.cursor.krasulia.hw7.task1_2.Continent.*;

public enum Country {
    UKRAINE("Ukraine", EUROPE),
    POLAND("Poland", EUROPE),
    FRANCE("France", EUROPE),
    CHINA("China", ASIA),
    INDIA("India", ASIA),
    ISRAEL("Israel", ASIA),
    EGYPT("Egypt", AFRICA),
    ALGERIA("Algeria", AFRICA),
    ANGOLA("Angola", AFRICA),
    USA("USA", NORTH_AMERICA),
    CANADA("Canada", NORTH_AMERICA),
    MEXICO("Mexico", NORTH_AMERICA),
    BRAZIL("Brazil", SOUTH_AMERICA),
    ARGENTINA("Argentina", SOUTH_AMERICA),
    BOLIVIA("Bolivia", SOUTH_AMERICA),
    AUSTRALIA("Australia", OCEANIA),
    FIJI("Fiji", OCEANIA),
    NEW_ZEALAND("New Zealand", OCEANIA);

    private final String country;
    private final Continent continent;

    Country(String country, Continent continent) {
        this.country = country;
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public Continent getContinent() {
        return continent;
    }
}

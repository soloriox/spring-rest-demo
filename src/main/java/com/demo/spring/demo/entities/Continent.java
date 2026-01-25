package com.demo.spring.demo.entities;

import java.util.Arrays;

public enum Continent {

    ASIA("Asia"),
    EUROPE("Europe"),
    AMERICA("America"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica");

    private final String continentName;

    Continent(String continentName){
        this.continentName = continentName;
    }

    @Override
    public String toString() {
        return this.continentName;
    }


    public String getContinentName() {
        return this.continentName;
    }

    public static Continent getByContinent(String name) {
        return Arrays.stream(Continent.values())
            .filter(Continent -> Continent.getContinentName().equals(name))
            .findFirst().orElseThrow();
    }
}

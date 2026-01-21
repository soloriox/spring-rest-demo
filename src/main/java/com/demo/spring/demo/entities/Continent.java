package com.demo.spring.demo.entities;

public enum Continent {

    ASIA("Asia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica"),
    SOUTH_AMERICA("South America");

    private final String continentName;

    Continent(String continentName){
        this.continentName = continentName;
    }

    @Override
    public String toString() {
        return this.continentName;
    }

}

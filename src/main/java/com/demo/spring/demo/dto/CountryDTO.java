package com.demo.spring.demo.dto;

import com.demo.spring.demo.entities.City;
import com.demo.spring.demo.entities.Country;
import com.demo.spring.demo.entities.CountryLanguage;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"countryCode", "name", "continent", "region", "surfaceArea", "population", "lifeExpectancy", "languages", "cities"})
public class CountryDTO {

    private String countryCode;
    private String name;
    private String continent;
    private String region;
    private double surfaceArea;
    private Short independenceYear;
    private int population;
    private Float lifeExpectancy;
    private List<LanguageReduceDTO> languages;
    private List<CityReduceDTO> cities;

    public CountryDTO(Country country){
        this.countryCode = country.getCountryCode();
        this.name = country.getName();
        this.continent = country.getContinent().getContinentName();
        this.region = country.getRegion();
        this.surfaceArea = country.getSurfaceArea();
        this.independenceYear = country.getIndependenceYear();
        this.population = country.getPopulation();
        this.lifeExpectancy = country.getLifeExpectancy();
        this.languages = new ArrayList<>();
        this.cities = new ArrayList<>();
        for(CountryLanguage countryLanguage: country.getLanguages()){
            LanguageReduceDTO language = new LanguageReduceDTO(countryLanguage);
            this.languages.add(language);
        }
        for(City countryCity: country.getCities()){
            CityReduceDTO city = new CityReduceDTO(countryCity);
            this.cities.add(city);
        }
    }

    public CountryDTO(){

    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Short getIndependenceYear() {
        return independenceYear;
    }

    public void setIndependenceYear(Short independenceYear) {
        this.independenceYear = independenceYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public List<LanguageReduceDTO> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageReduceDTO> languages) {
        this.languages = languages;
    }

    public List<CityReduceDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityReduceDTO> cities) {
        this.cities = cities;
    }
}

package com.demo.spring.demo.entities;

import com.demo.spring.demo.config.ContinentConverter;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Country")
public class Country {

    @Id
    @Column(name = "country_code", unique = true, nullable = false)
    private String countryCode;

    @Column(name = "name", length = 52, nullable = false)
    private String name;

    @Convert(converter = ContinentConverter.class)
    @Column(name = "continent", nullable = false, columnDefinition = "ENUM('Asia','Europe','North America','Africa','Oceania','Antarctica','South America')")
    private Continent continent;

    @Column(name = "region", length = 26, nullable = false)
    private String region;

    @Column(name = "surface_area", nullable = false)
    private double surfaceArea;

    @Column(name = "independence_year", nullable = true)
    private Short independenceYear;

    @Column(name = "population", nullable = false)
    private int population;

    @Column(name = "life_expectancy", nullable = true)
    private Float lifeExpectancy;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<CountryLanguage> languages;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<City> cities;

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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
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

    public List<CountryLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(List<CountryLanguage> languages) {
        this.languages = languages;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
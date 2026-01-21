package com.demo.spring.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "Code", unique = true, nullable = false)
    private String code;

    @Column(name = "Name", length = 52, nullable = false)
    private String name;

    @Column(name = "Continent", nullable = false)
    private Continent continent;

    @Column(name = "Region", length = 26, nullable = false)
    private String region;

    @Column(name = "SurfaceArea", nullable = false)
    private double surfaceArea;

    @Column(name = "IndepYear", nullable = true)
    private short indepYear;

    @Column(name = "Population", nullable = false)
    private int population;

    @Column(name = "lifeExpectancy", nullable = true)
    private float lifeExpectancy;

    @Column(name = "GNP", nullable = true)
    private float gnp;

    @Column(name = "GNPOld", nullable = true)
    private float gnpOld;

    @Column(name = "LocalName", length = 45, nullable = false)
    private String localName;

    @Column(name = "governmentForm", length = 45, nullable = false)
    private String governmentForm;

    @Column(name = "HeadOfState", length = 60, nullable = true)
    private String headOfState;

    @Column(name = "Capital", nullable = true)
    private int capital;

    @Column(name = "Code2", length = 2, nullable = false)
    private String code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<CountryLanguage> languages;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(short indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public float getGnp() {
        return gnp;
    }

    public void setGnp(float gnp) {
        this.gnp = gnp;
    }

    public float getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(float gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
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
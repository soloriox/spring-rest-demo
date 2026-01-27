package com.demo.spring.demo.dto;

import com.demo.spring.demo.entities.City;
import com.demo.spring.demo.entities.Country;

public class CityDTO {

    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;
    private String country;

    public CityDTO(City city){
        this.id = city.getId();
        this.name = city.getName();
        this.countryCode = city.getCountry().getCountryCode();
        this.district = city.getDistrict();
        this.population = city.getPopulation();
        this.country = city.getCountry().getName();
    }

    public CityDTO(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

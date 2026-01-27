package com.demo.spring.demo.dto;

import com.demo.spring.demo.entities.City;

public class CityReduceDTO {

    private int id;
    private String name;
    private String district;
    private int population;

    public CityReduceDTO(City city){
        this.id = city.getId();
        this.name = city.getName();
        this.district = city.getDistrict();
        this.population = city.getPopulation();
    }

    public CityReduceDTO(){

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
}

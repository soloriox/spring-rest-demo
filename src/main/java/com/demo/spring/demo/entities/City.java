package com.demo.spring.demo.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "Name", length = 35, nullable = false)
    private String name;

    @Column(name = "CountryCode", length = 3, nullable = false)
    private String countryCode;

    @Column(name = "District", length = 20, nullable = false)
    private String district;

    @Column(name="Population", nullable = false)
    private int population;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

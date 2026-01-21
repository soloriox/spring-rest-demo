package com.demo.spring.demo.entities;

import jakarta.persistence.*;

@Entity
@IdClass(CountryLanguagePrimaryKey.class)
@Table(name = "countrylanguage")
public class CountryLanguage {

    @Id
    @Column(name = "CountryCode", unique = true, nullable = false)
    private String countryCode;

    @Id
    @Column(name = "Language", length = 30, nullable = false)
    private String language;

    @Column(name = "IsOfficial", nullable = false)
    private IsOfficial isOfficial;

    @Column(name = "Percentage", nullable = false)
    private float percentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private Country country;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public IsOfficial getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(IsOfficial isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

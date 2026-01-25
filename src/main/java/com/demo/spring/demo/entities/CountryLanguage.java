package com.demo.spring.demo.entities;

import jakarta.persistence.*;

@Entity
@IdClass(CountryLanguagePrimaryKey.class)
@Table(name = "CountryLanguage")
public class CountryLanguage {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_code")
    private Country country;

    @Id
    @Column(name = "language", length = 30, nullable = false)
    private String language;

    @Column(name = "is_official", nullable = false)
    @Enumerated(EnumType.STRING)
    private IsOfficial isOfficial;

    @Column(name = "percentage", nullable = false)
    private float percentage;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

}

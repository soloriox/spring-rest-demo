package com.demo.spring.demo.entities;

import java.util.Objects;

public class CountryLanguagePrimaryKey {

    private Country country;
    private String language;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguagePrimaryKey that = (CountryLanguagePrimaryKey) o;
        return Objects.equals(country, that.country) && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, language);
    }

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
}

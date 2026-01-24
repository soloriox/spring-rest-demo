package com.demo.spring.demo.dto;

import com.demo.spring.demo.entities.CountryLanguage;
import com.demo.spring.demo.entities.IsOfficial;

public class LanguageDTO {

    private String countryCode;
    private String language;
    private IsOfficial isOfficial;
    private float percentage;
    private String countryName;

    public LanguageDTO(CountryLanguage countryLanguage){
        this.countryCode = countryLanguage.getCountryCode();
        this.language = countryLanguage.getLanguage();
        this.isOfficial = countryLanguage.getIsOfficial();
        this.percentage = countryLanguage.getPercentage();
        this.countryName = countryLanguage.getCountry().getName();
    }

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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}

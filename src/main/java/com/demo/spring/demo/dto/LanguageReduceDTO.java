package com.demo.spring.demo.dto;

import com.demo.spring.demo.entities.CountryLanguage;

public class LanguageReduceDTO {

    private String language;
    private boolean isOfficial;
    private float percentage;

    public LanguageReduceDTO(CountryLanguage countryLanguage){
        this.language = countryLanguage.getLanguage();
        this.isOfficial = countryLanguage.getIsOfficial().getValue();
        this.percentage = countryLanguage.getPercentage();
    }

    public LanguageReduceDTO(){

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}

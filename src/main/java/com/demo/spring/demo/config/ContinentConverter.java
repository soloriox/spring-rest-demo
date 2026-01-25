package com.demo.spring.demo.config;

import com.demo.spring.demo.entities.Continent;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ContinentConverter implements AttributeConverter<Continent, String> {

    @Override
    public String convertToDatabaseColumn(Continent continent) {
        return continent != null ? continent.getContinentName() : null;
    }

    @Override
    public Continent convertToEntityAttribute(String continentName) {
        return continentName != null ? Continent.getByContinent(continentName) : null;
    }
}

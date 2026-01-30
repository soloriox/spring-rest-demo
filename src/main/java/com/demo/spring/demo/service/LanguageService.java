package com.demo.spring.demo.service;

import com.demo.spring.demo.dto.LanguageDTO;
import com.demo.spring.demo.entities.Country;
import com.demo.spring.demo.repository.CountryRepository;
import com.demo.spring.demo.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final CountryRepository countryRepository;
    private final Logger logger = Logger.getLogger(LanguageService.class.getName());

    @Autowired
    public LanguageService(LanguageRepository languageRepository, CountryRepository countryRepository){
        this.languageRepository = languageRepository;
        this.countryRepository = countryRepository;
    }

    public List<LanguageDTO> getAll(){
        logger.log(Level.INFO, "getAll()");
        List<LanguageDTO> languages = this.languageRepository.findAll()
                .stream()
                .map(LanguageDTO::new)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "getAll() -> return List of : " + LanguageDTO.class.getName()
                + " with " + languages.size() + " items.");
        return languages;
    }

    public List<LanguageDTO> getByLanguage(String language){
        logger.log(Level.INFO, "getByLanguage(" + language + ")");
        List<LanguageDTO> languages = this.languageRepository.findByLanguage(language)
                .stream()
                .map(LanguageDTO::new)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "getByLanguage(" + language + ") -> return List of : " + LanguageDTO.class.getName()
                + " with " + languages.size() + " items.");
        return languages;
    }

    public List<LanguageDTO> getByCountry(String countryCode){
        logger.log(Level.INFO, "getByCountry(" + countryCode + ")");
        Optional<Country> country = this.countryRepository.findById(countryCode);
        List<LanguageDTO> languages = this.languageRepository.findByCountry(country.get())
                .stream()
                .map(LanguageDTO::new)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "getByCountry(" + countryCode + ") -> return List of : " + LanguageDTO.class.getName()
                + " with " + languages.size() + " items.");
        return languages;
    }

}

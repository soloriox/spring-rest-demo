package com.demo.spring.demo.service;

import com.demo.spring.demo.dto.LanguageDTO;
import com.demo.spring.demo.entities.Country;
import com.demo.spring.demo.entities.CountryLanguage;
import com.demo.spring.demo.repository.CountryRepository;
import com.demo.spring.demo.repository.LanguageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LanguageService(LanguageRepository languageRepository, ModelMapper modelMapper, CountryRepository countryRepository){
        this.languageRepository = languageRepository;
        this.modelMapper = modelMapper;
        this.countryRepository = countryRepository;
    }

    public List<LanguageDTO> getAll(){
        List<LanguageDTO> languages = this.languageRepository.findAll()
                .stream()
                .map(LanguageDTO::new)
                .collect(Collectors.toList());

        return languages;
    }

    public List<LanguageDTO> getByLanguage(String language){
        List<LanguageDTO> languages = this.languageRepository.findByLanguage(language)
                .stream()
                .map(LanguageDTO::new)
                .collect(Collectors.toList());
        return languages;
    }

    public List<LanguageDTO> getByCountry(String countryCode){
        Optional<Country> country = this.countryRepository.findById(countryCode);
        List<LanguageDTO> languages = this.languageRepository.findByCountry(country.get())
                .stream()
                .map(LanguageDTO::new)
                .collect(Collectors.toList());
        return languages;
    }

}

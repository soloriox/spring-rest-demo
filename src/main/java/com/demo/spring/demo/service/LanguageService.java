package com.demo.spring.demo.service;

import com.demo.spring.demo.dto.LanguageDTO;
import com.demo.spring.demo.entities.CountryLanguage;
import com.demo.spring.demo.repository.LanguageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LanguageService(LanguageRepository languageRepository, ModelMapper modelMapper){
        this.languageRepository = languageRepository;
        this.modelMapper = modelMapper;
    }

    public List<LanguageDTO> getAll(){
        List<LanguageDTO> languages = this.languageRepository.findAll()
                .stream()
                .map(LanguageDTO::new)
                .collect(Collectors.toList());

        return languages;
    }

    public LanguageDTO getByLanguage(String language){
        CountryLanguage countryLanguage = this.languageRepository.findByLanguage(language);
        LanguageDTO languageDTO = this.modelMapper.map(countryLanguage, LanguageDTO.class);
        return languageDTO;
    }

    public List<LanguageDTO> getByCountryCode(String countryCode){
        List<LanguageDTO> languages = this.languageRepository.findByCountryCode(countryCode)
                .stream()
                .map(LanguageDTO::new)
                .collect(Collectors.toList());
        return languages;
    }

}

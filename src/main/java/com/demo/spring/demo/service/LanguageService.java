package com.demo.spring.demo.service;

import com.demo.spring.demo.dto.LanguageDTO;
import com.demo.spring.demo.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    public List<LanguageDTO> getAll(){
        List<LanguageDTO> languages = new ArrayList<LanguageDTO>();
        return languages;
    }

    public LanguageDTO getByLanguage(String language){
        LanguageDTO languageDto = new LanguageDTO();
        return languageDto;
    }

    public List<LanguageDTO> getByCountryCode(String countryCode){
        List<LanguageDTO> languages = new ArrayList<LanguageDTO>();
        return languages;
    }

}

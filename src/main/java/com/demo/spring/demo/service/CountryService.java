package com.demo.spring.demo.service;

import com.demo.spring.demo.dto.CountryDTO;
import com.demo.spring.demo.entities.Country;
import com.demo.spring.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public List<CountryDTO> getAll(){
        List<CountryDTO> countries = new ArrayList<CountryDTO>();

        return countries;
    }

    public CountryDTO getByCode(String code){
        CountryDTO country = new CountryDTO();
        Optional<Country> countryEntity = this.countryRepository.findById(code);

        return country;
    }
}

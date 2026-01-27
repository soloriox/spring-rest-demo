package com.demo.spring.demo.service;

import com.demo.spring.demo.dto.CountryDTO;
import com.demo.spring.demo.entities.Country;
import com.demo.spring.demo.repository.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CountryService(CountryRepository countryRepository, ModelMapper modelMapper){
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CountryDTO> getAll(){
        List<CountryDTO> countries = this.countryRepository.findAll()
                .stream()
                .map(CountryDTO::new)
                .collect(Collectors.toList());

        return countries;
    }

    public CountryDTO getByCode(String code){
        Optional<Country> countryEntity = this.countryRepository.findById(code);
        CountryDTO countryResponse = new CountryDTO(countryEntity.get());
        return countryResponse;
    }

    public CountryDTO getByName(String name){
        Country country = this.countryRepository.findByName(name);
        CountryDTO countryResponse = new CountryDTO(country);
        return countryResponse;
    }
}

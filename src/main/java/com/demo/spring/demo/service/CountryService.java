package com.demo.spring.demo.service;

import com.demo.spring.demo.dto.CountryDTO;
import com.demo.spring.demo.entities.Country;
import com.demo.spring.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final Logger logger = Logger.getLogger(CountryService.class.getName());

    @Autowired
    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public List<CountryDTO> getAll(){
        logger.log(Level.INFO, "getAll()");
        List<CountryDTO> countries = this.countryRepository.findAll()
                .stream()
                .map(CountryDTO::new)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "getAll() -> return List of : " + CountryDTO.class.getName()
                + " with " + countries.size() + " items.");
        return countries;
    }

    public CountryDTO getByCode(String code){
        logger.log(Level.INFO, "getByCode(" + code + ")");
        Optional<Country> countryEntity = this.countryRepository.findById(code);
        CountryDTO countryResponse = new CountryDTO(countryEntity.get());
        logger.log(Level.INFO, "getAll() -> return Object type of : " + CountryDTO.class.getName()
                + " - id: " +  countryResponse.getCountryCode() + " , name: " + countryResponse.getName());
        return countryResponse;
    }

    public CountryDTO getByName(String name){
        logger.log(Level.INFO, "getByName(" + name + ")");
        Country country = this.countryRepository.findByName(name);
        CountryDTO countryResponse = new CountryDTO(country);
        logger.log(Level.INFO, "getByName(" + name + ") -> return Object type of : " + CountryDTO.class.getName()
                + " - id: " +  countryResponse.getCountryCode() + " , name: " + countryResponse.getName());
        return countryResponse;
    }
}

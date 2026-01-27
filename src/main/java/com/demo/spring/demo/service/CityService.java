package com.demo.spring.demo.service;

import com.demo.spring.demo.dto.CityDTO;
import com.demo.spring.demo.dto.LanguageDTO;
import com.demo.spring.demo.entities.Country;
import com.demo.spring.demo.repository.CityRepository;
import com.demo.spring.demo.repository.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CityService(CityRepository cityRepository, CountryRepository countryRepository, ModelMapper modelMapper){
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CityDTO> getAll(){
        List<CityDTO> cities = this.cityRepository.findAll()
                .stream()
                .map(CityDTO::new)
                .collect(Collectors.toList());
        return cities;
    }

    public List<CityDTO> getByCountryCode(String code){
        Optional<Country> country = this.countryRepository.findById(code);
        List<CityDTO> cities = this.cityRepository.findByCountry(country.get())
                .stream()
                .map(CityDTO::new)
                .collect(Collectors.toList());
        return cities;
    }

    public List<CityDTO> getByCountryName(String countryName){
        Country country = this.countryRepository.findByName(countryName);
        List<CityDTO> cities = this.cityRepository.findByCountry(country)
                .stream()
                .map(CityDTO::new)
                .collect(Collectors.toList());
        return cities;
    }

    public CityDTO getById(int id){
        CityDTO city = this.modelMapper.map(
                this.cityRepository.findById(id),
                CityDTO.class);
        return city;
    }

    public List<CityDTO> getByName(String name){
        List<CityDTO> cities = this.cityRepository.findByName(name)
                .stream()
                .map(CityDTO::new)
                .collect(Collectors.toList());
        return cities;
    }

}

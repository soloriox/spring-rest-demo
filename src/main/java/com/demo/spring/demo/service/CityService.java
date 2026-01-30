package com.demo.spring.demo.service;

import com.demo.spring.demo.dto.CityDTO;
import com.demo.spring.demo.entities.Country;
import com.demo.spring.demo.repository.CityRepository;
import com.demo.spring.demo.repository.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final Logger logger = Logger.getLogger(CityService.class.getName());

    @Autowired
    public CityService(CityRepository cityRepository, CountryRepository countryRepository, ModelMapper modelMapper){
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CityDTO> getAll(){
        logger.log(Level.INFO, "getAll()");
        List<CityDTO> cities = this.cityRepository.findAll()
                .stream()
                .map(CityDTO::new)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "getAll() -> return List of : " + CityDTO.class.getName()
                + " with " + cities.size() + " items.");
        return cities;
    }

    public List<CityDTO> getByCountryCode(String code){
        logger.log(Level.INFO, "getByCountryCode(" + code+ ")");
        Optional<Country> country = this.countryRepository.findById(code);
        List<CityDTO> cities = this.cityRepository.findByCountry(country.get())
                .stream()
                .map(CityDTO::new)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "getByCountryCode(" + code+ ") -> return List of : " + CityDTO.class.getName()
                + " with " + cities.size() + " items.");
        return cities;
    }

    public List<CityDTO> getByCountryName(String countryName){
        logger.log(Level.INFO, "getByCountryName(" + countryName+ ")");
        Country country = this.countryRepository.findByName(countryName);
        List<CityDTO> cities = this.cityRepository.findByCountry(country)
                .stream()
                .map(CityDTO::new)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "getByCountryName(" + countryName + ") -> return List of : " + CityDTO.class.getName()
                + " with " + cities.size() + " items.");
        return cities;
    }

    public CityDTO getById(int id){
        logger.log(Level.INFO, "getById(" + id + ")");
        CityDTO city = this.modelMapper.map(
                this.cityRepository.findById(id),
                CityDTO.class);
        logger.log(Level.INFO, "getById(" + id + ") -> return Object type of : " + CityDTO.class.getName()
                + " - id: " +  city.getId() + " , name: " + city.getName());
        return city;
    }

    public List<CityDTO> getByName(String name){
        logger.log(Level.INFO, "getByName(" + name + ")");
        List<CityDTO> cities = this.cityRepository.findByName(name)
                .stream()
                .map(CityDTO::new)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "getByName(" + name + ") -> return List of : " + CityDTO.class.getName()
                + " with " + cities.size() + " items.");
        return cities;
    }

}

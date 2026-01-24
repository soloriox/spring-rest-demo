package com.demo.spring.demo.service;

import com.demo.spring.demo.dto.CityDTO;
import com.demo.spring.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public List<CityDTO> getAll(){
        List<CityDTO> cities = new ArrayList<CityDTO>();

        return cities;
    }

    public List<CityDTO> getByCountryCode(String code){
        List<CityDTO> cities = new ArrayList<CityDTO>();

        return cities;
    }

    public List<CityDTO> getByCountryName(String code){
        List<CityDTO> cities = new ArrayList<CityDTO>();

        return cities;
    }

    public CityDTO getById(int id){
        CityDTO city = new CityDTO();

        return city;
    }

    public CityDTO getByName(String name){
        CityDTO city = new CityDTO();

        return city;
    }

}

package com.demo.spring.demo.rest;

import com.demo.spring.demo.dto.CityDTO;
import com.demo.spring.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CityDTO>> getAll(){
        List<CityDTO> cities = this.cityService.getAll();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/country-code/{countryCode}")
    public ResponseEntity<List<CityDTO>> getByCountryCode(@PathVariable String countryCode){
        List<CityDTO> cities = this.cityService.getByCountryCode(countryCode);
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/country-name/{countryName}")
    public ResponseEntity<List<CityDTO>> getByCountryName(@PathVariable String countryName){
        List<CityDTO> cities = this.cityService.getByCountryName(countryName);
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/city-code/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable int id){
        CityDTO city = this.cityService.getById(id);
        return ResponseEntity.ok(city);
    }

    @GetMapping("/city-name/{name}")
    public ResponseEntity<List<CityDTO>> getByName(@PathVariable String name){
        List<CityDTO> cities = this.cityService.getByName(name);
        return ResponseEntity.ok(cities);
    }
}

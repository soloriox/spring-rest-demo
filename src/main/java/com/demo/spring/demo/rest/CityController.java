package com.demo.spring.demo.rest;

import com.demo.spring.demo.dto.CityDTO;
import com.demo.spring.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
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
    public ResponseEntity<List<CityDTO>> getByCountryCode(@RequestParam String countryCode){
        List<CityDTO> cities = this.cityService.getByCountryCode(countryCode);
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/country-name/{countryName}")
    public ResponseEntity<List<CityDTO>> getByCountryName(@RequestParam String countryName){
        List<CityDTO> cities = this.cityService.getByCountryName(countryName);
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getById(@RequestParam int id){
        CityDTO city = this.cityService.getById(id);
        return ResponseEntity.ok(city);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CityDTO> getByName(@RequestParam String name){
        CityDTO city = this.cityService.getByName(name);
        return ResponseEntity.ok(city);
    }
}

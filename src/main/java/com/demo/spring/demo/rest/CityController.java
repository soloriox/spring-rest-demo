package com.demo.spring.demo.rest;

import com.demo.spring.demo.config.PathMapping;
import com.demo.spring.demo.dto.CityDTO;
import com.demo.spring.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(PathMapping.CITIES)
public class CityController {

    private static final Logger logger = Logger.getLogger(CityController.class.getName());
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping(PathMapping.GET_ALL)
    public ResponseEntity<List<CityDTO>> getAll(){
        try{
            List<CityDTO> cities = this.cityService.getAll();
            return ResponseEntity.ok(cities);
        } catch (Exception e){
            logger.log(Level.SEVERE, e.toString());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(PathMapping.COUNTRY_CODE + "{countryCode}")
    public ResponseEntity<List<CityDTO>> getByCountryCode(@PathVariable String countryCode){
        try{
            List<CityDTO> cities = this.cityService.getByCountryCode(countryCode);
            return ResponseEntity.ok(cities);
        } catch (Exception e){
            logger.log(Level.SEVERE, e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(PathMapping.COUNTRY_NAME + "{countryName}")
    public ResponseEntity<List<CityDTO>> getByCountryName(@PathVariable String countryName){
        try{
            List<CityDTO> cities = this.cityService.getByCountryName(countryName);
            return ResponseEntity.ok(cities);
        } catch (Exception e){
            logger.log(Level.SEVERE, e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(PathMapping.CITY_CODE + "{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable int id){
        try{
            CityDTO city = this.cityService.getById(id);
            return ResponseEntity.ok(city);
        } catch (Exception e){
            logger.log(Level.SEVERE, e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(PathMapping.CITY_NAME + "{name}")
    public ResponseEntity<List<CityDTO>> getByName(@PathVariable String name){
        try{
            List<CityDTO> cities = this.cityService.getByName(name);
            return ResponseEntity.ok(cities);
        } catch (Exception e){
            logger.log(Level.SEVERE, e.toString());
            return ResponseEntity.notFound().build();
        }
    }
}

package com.demo.spring.demo.rest;

import com.demo.spring.demo.config.PathMapping;
import com.demo.spring.demo.dto.CountryDTO;
import com.demo.spring.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(PathMapping.COUNTRIES)
public class CountryController {

    private final Logger logger = Logger.getLogger(CountryController.class.getName());
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping(PathMapping.GET_ALL)
    public ResponseEntity<List<CountryDTO>> getCountries() {
        try{
            List<CountryDTO> countries = this.countryService.getAll();
            return ResponseEntity.ok(countries);
        } catch (Exception e){
            logger.log(Level.SEVERE, e.toString());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(PathMapping.COUNTRY_CODE + "{countryCode}")
    public ResponseEntity<CountryDTO> getByCountryCode(@PathVariable String countryCode) {
        try{
            CountryDTO country = this.countryService.getByCode(countryCode);
            return ResponseEntity.ok(country);
        } catch (Exception e){
            logger.log(Level.SEVERE, e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(PathMapping.COUNTRY_NAME + "{countryName}")
    public ResponseEntity<CountryDTO> getByCountryName(@PathVariable String countryName) {
        try{
            CountryDTO country = this.countryService.getByName(countryName);
            return ResponseEntity.ok(country);
        } catch (Exception e){
            logger.log(Level.SEVERE, e.toString());
            return ResponseEntity.notFound().build();
        }
    }
}

package com.demo.spring.demo.rest;

import com.demo.spring.demo.dto.CountryDTO;
import com.demo.spring.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CountryDTO>> getCountries() {
        List<CountryDTO> countries = this.countryService.getAll();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/country-code/{countryCode}")
    public ResponseEntity<CountryDTO> getByCountryCode(@PathVariable String countryCode) {
        CountryDTO country = this.countryService.getByCode(countryCode);
        return ResponseEntity.ok(country);
    }

    @GetMapping("/country-name/{countryName}")
    public ResponseEntity<CountryDTO> getByCountryName(@PathVariable String countryName) {
        CountryDTO country = this.countryService.getByName(countryName);
        return ResponseEntity.ok(country);
    }
}

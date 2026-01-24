package com.demo.spring.demo.rest;

import com.demo.spring.demo.dto.CountryDTO;
import com.demo.spring.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
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

    @GetMapping("/{countryCode}")
    public ResponseEntity<CountryDTO> getByCountryCode(@RequestParam String countryCode) {
        CountryDTO country = this.countryService.getByCode(countryCode);
        return ResponseEntity.ok(country);
    }
}

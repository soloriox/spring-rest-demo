package com.demo.spring.demo.rest;

import com.demo.spring.demo.dto.LanguageDTO;
import com.demo.spring.demo.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<LanguageDTO>> getAll(){
        List<LanguageDTO> languages = this.languageService.getAll();
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<LanguageDTO>> getByLanguage(@PathVariable String language){
        List<LanguageDTO> languages = this.languageService.getByLanguage(language);
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/country-code/{countryCode}")
    public ResponseEntity<List<LanguageDTO>> getByCountryCode(@PathVariable String countryCode){
        List<LanguageDTO> languages = this.languageService.getByCountry(countryCode);
        return ResponseEntity.ok(languages);
    }
}

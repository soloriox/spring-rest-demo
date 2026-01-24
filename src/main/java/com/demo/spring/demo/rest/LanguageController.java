package com.demo.spring.demo.rest;

import com.demo.spring.demo.dto.LanguageDTO;
import com.demo.spring.demo.service.LanguageService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/language")
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

    @GetMapping("/{language}")
    public ResponseEntity<LanguageDTO> getByLanguage(@RequestParam String language){
        LanguageDTO languageResponse = this.languageService.getByLanguage(language);
        return ResponseEntity.ok(languageResponse);
    }

    @GetMapping("/{countryCode}")
    public ResponseEntity<List<LanguageDTO>> getByCountryCode(@RequestParam String countryCode){
        List<LanguageDTO> languages = this.languageService.getByCountryCode(countryCode);
        return ResponseEntity.ok(languages);
    }
}

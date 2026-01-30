package com.demo.spring.demo.rest;

import com.demo.spring.demo.config.PathMapping;
import com.demo.spring.demo.dto.LanguageDTO;
import com.demo.spring.demo.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(PathMapping.LANGUAGES)
public class LanguageController {

    private final Logger logger = Logger.getLogger(LanguageController.class.getName());
    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }

    @GetMapping(PathMapping.GET_ALL)
    public ResponseEntity<List<LanguageDTO>> getAll(){
        try{
            List<LanguageDTO> languages = this.languageService.getAll();
            return ResponseEntity.ok(languages);
        } catch (Exception e){
            logger.log(Level.SEVERE, e.toString());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(PathMapping.LANGUAGE + "{language}")
    public ResponseEntity<List<LanguageDTO>> getByLanguage(@PathVariable String language){
        try{
            List<LanguageDTO> languages = this.languageService.getByLanguage(language);
            return ResponseEntity.ok(languages);
        } catch (Exception e){
            logger.log(Level.SEVERE, e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(PathMapping.COUNTRY_CODE + "{countryCode}")
    public ResponseEntity<List<LanguageDTO>> getByCountryCode(@PathVariable String countryCode){
        try {
            List<LanguageDTO> languages = this.languageService.getByCountry(countryCode);
            return ResponseEntity.ok(languages);
        } catch (Exception e){
            logger.log(Level.SEVERE, e.toString());
            return ResponseEntity.notFound().build();
        }
    }
}

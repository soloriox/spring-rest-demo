package com.demo.spring.demo.repository;

import com.demo.spring.demo.entities.Country;
import com.demo.spring.demo.entities.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<CountryLanguage, String> {

    List<CountryLanguage> findByLanguage(String language);

    List<CountryLanguage> findByCountry(Country country);
}

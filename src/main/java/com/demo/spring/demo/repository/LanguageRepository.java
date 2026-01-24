package com.demo.spring.demo.repository;

import com.demo.spring.demo.entities.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<CountryLanguage, String> {

}

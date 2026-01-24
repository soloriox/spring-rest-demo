package com.demo.spring.demo.repository;

import com.demo.spring.demo.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}

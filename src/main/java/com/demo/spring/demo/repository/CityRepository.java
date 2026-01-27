package com.demo.spring.demo.repository;

import com.demo.spring.demo.entities.City;
import com.demo.spring.demo.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByCountry(Country country);

    List<City> findByName(String name);
}

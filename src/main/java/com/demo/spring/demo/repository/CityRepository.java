package com.demo.spring.demo.repository;

import com.demo.spring.demo.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}

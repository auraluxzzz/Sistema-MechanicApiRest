package com.angelogarcia.mechanicapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angelogarcia.mechanicapirest.model.Brand;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    
}

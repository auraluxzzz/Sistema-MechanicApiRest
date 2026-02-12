package com.angelogarcia.mechanicapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angelogarcia.mechanicapirest.model.CarModel;

public interface CarModelRepository extends JpaRepository<CarModel,Long>{
    

}

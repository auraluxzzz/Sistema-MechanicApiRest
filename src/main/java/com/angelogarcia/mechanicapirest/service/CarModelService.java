package com.angelogarcia.mechanicapirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelogarcia.mechanicapirest.model.CarModel;
import com.angelogarcia.mechanicapirest.repository.CarModelRepository;

@Service
public class CarModelService implements ICarModelService{

    @Autowired
    CarModelRepository carModelRepository;
    @Override
    public List<CarModel> listCarModels(){
        return carModelRepository.findAll();
    }

    @Override
    public void saveCarModel(CarModel carModel){
        carModelRepository.save(carModel);
    }

    @Override
    public CarModel serchCarModelForId(Long id){
        return carModelRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCarModel(CarModel carModel){
        carModelRepository.delete(carModel);
    }
}

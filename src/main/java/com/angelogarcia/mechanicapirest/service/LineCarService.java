package com.angelogarcia.mechanicapirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelogarcia.mechanicapirest.model.LineCar;
import com.angelogarcia.mechanicapirest.repository.LineCarRepository;

@Service
public class LineCarService implements ILineCarService{

@Autowired
    LineCarRepository lineCarRepository;
    @Override
    public List<LineCar> listLineCars(){
        return lineCarRepository.findAll();
    }

    @Override
    public void saveLineCar(LineCar lineCar){
        lineCarRepository.save(lineCar);
    }

    @Override
    public LineCar serchLineCarForId(Long id){
        return lineCarRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteLineCar(LineCar lineCar){
        lineCarRepository.delete(lineCar);
    }

}

package com.angelogarcia.mechanicapirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelogarcia.mechanicapirest.model.Brand;
import com.angelogarcia.mechanicapirest.repository.BrandRepository;

@Service
public class BrandService implements IBrandService{

    @Autowired
    BrandRepository brandRepository;
    @Override
    public List<Brand> listBrands() {
        return brandRepository.findAll();
    }

    @Override
    public void saveBrand(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public Brand serchBrandForId(Long id) {
        return brandRepository.findById(id).orElse(null); // como el try cath
    }

    @Override
    public void deleteBrand(Brand brand) {
        brandRepository.delete(brand);
    }
        

}

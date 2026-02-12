package com.angelogarcia.mechanicapirest.service;

import java.util.List;

import com.angelogarcia.mechanicapirest.model.Brand;
public interface IBrandService {

    //Listar
    public List<Brand> listBrands();

    //Agregar y Editar
    public void saveBrand(Brand brand);

    //Buscar
    public Brand serchBrandForId(Long id);

    //Eliminar método de clase
    public void deleteBrand(Brand brand);

}

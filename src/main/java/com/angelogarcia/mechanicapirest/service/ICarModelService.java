package com.angelogarcia.mechanicapirest.service;

import java.util.List;

import com.angelogarcia.mechanicapirest.model.CarModel;

public interface ICarModelService {

    //Listar
    public List<CarModel> listCarModels();

    //Agregar y Editar
    public void saveCarModel(CarModel carModel);

    //Buscar
    public CarModel serchCarModelForId(Long id);

    //Eliminar método de clase
    public void deleteCarModel(CarModel carModel);


}

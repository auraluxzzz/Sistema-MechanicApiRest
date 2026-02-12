package com.angelogarcia.mechanicapirest.service;

import java.util.List;

import com.angelogarcia.mechanicapirest.model.LineCar;

public interface ILineCarService {

    //Listar
    public List<LineCar> listLineCars();

    //Agregar y Editar
    public void saveLineCar(LineCar lineCar);

    //Buscar
    public LineCar serchLineCarForId(Long id);

    //Eliminar método de clase
    public void deleteLineCar(LineCar lineCar);

}

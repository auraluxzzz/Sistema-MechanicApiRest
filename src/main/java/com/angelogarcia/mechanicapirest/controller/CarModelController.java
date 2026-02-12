package com.angelogarcia.mechanicapirest.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.angelogarcia.mechanicapirest.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.angelogarcia.mechanicapirest.model.CarModel;
import com.angelogarcia.mechanicapirest.service.CarModelService;



@Controller
@RestController
@RequestMapping(value = "carModel")
public class CarModelController {

    @Autowired
    CarModelService carModelService;

    @GetMapping("/")
    public List<CarModel> listCarModels(){
        return carModelService.listCarModels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarModel> serchCarModelForId(@PathVariable Long id){
        try{
            return ResponseEntity.ok(carModelService.serchCarModelForId(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }


    @PostMapping("/")
    public void addCarModel(@RequestBody CarModel carModel){

        carModelService.saveCarModel(carModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> editCarModel(@PathVariable Long id, @RequestBody CarModel carModelNew){
        Map<String,String> response = new HashMap<>();   
        try{
            CarModel carModel = carModelService.serchCarModelForId(id);
            carModel.setDescription(carModelNew.getDescription());
            carModelService.saveCarModel(carModel);
            response.put("message", "The CarModel has been edited successfully");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("message", "The CarModel could not be edited.");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteCarModel(@PathVariable Long id){
        Map<String,String> response = new HashMap<>();
        try{
            CarModel carModel = carModelService.serchCarModelForId(id);
            carModelService.deleteCarModel(carModel);
            response.put("message", "CarModel successfully deleted");
            return ResponseEntity.ok(response);
        } catch (Exception e){
            response.put("message", "The CarModel could not be deleted");
            return ResponseEntity.badRequest().body(response);
            
        }
    }

}

package com.angelogarcia.mechanicapirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.angelogarcia.mechanicapirest.model.LineCar;
import com.angelogarcia.mechanicapirest.service.LineCarService;

@Controller
@RestController
@RequestMapping(value = "lineCar")
public class LineCarController {

    @Autowired
    LineCarService lineCarService;

    @GetMapping("/")
    public List<LineCar> listLineCars(){
        return lineCarService.listLineCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LineCar> serchLineCarForId(@PathVariable Long id){
        try{
            return ResponseEntity.ok(lineCarService.serchLineCarForId(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/")
    public void addLineCar(@RequestBody LineCar lineCar){
        lineCarService.saveLineCar(lineCar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> editLineCar(@PathVariable Long id, @RequestBody LineCar lineCarNew){
        Map<String, String> response = new HashMap<>();
        try{
            LineCar lineCar = lineCarService.serchLineCarForId(id);
            lineCar.setDescription(lineCarNew.getDescription());
            lineCarService.saveLineCar(lineCar);
            response.put("message", "The LineCar has been edited successfully.");;
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("message", "The LineCar could not be edited.");
            return ResponseEntity.badRequest().body(response);
        }
    }

        @DeleteMapping("/{id}")
        public ResponseEntity<Map<String,String>> deleteLineCar(@PathVariable Long id){
            Map<String, String> response = new HashMap<>();
            try{
                LineCar lineCar = lineCarService.serchLineCarForId(id);
                lineCar.setDescription(lineCar.getDescription());
                lineCarService.deleteLineCar(lineCar);
                response.put("message", "LineCar successfully deleted");
                return ResponseEntity.ok(response);
            } catch(Exception e){
                response.put("message", "The LineCar could not be deleted");
                return ResponseEntity.badRequest().body(response);
            }
        }
}


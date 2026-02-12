package com.angelogarcia.mechanicapirest.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

import com.angelogarcia.mechanicapirest.model.Brand;
import com.angelogarcia.mechanicapirest.service.BrandService;

@Controller
@RestController
@RequestMapping(value = "brand")
public class BrandController {

    @Autowired
    BrandService brandService;
    
    @GetMapping("/")
    public List<Brand> listBrands(){
        return brandService.listBrands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> serchBrandForId(@PathVariable Long id){
        try{
            return ResponseEntity.ok(brandService.serchBrandForId(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }


    @PostMapping("/")
    public void addBrand(@RequestBody Brand brand){

        brandService.saveBrand(brand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> editBrand(@PathVariable Long id, @RequestBody Brand brandNew){
        Map<String,String> response = new HashMap<>();
        try{
            Brand brand = brandService.serchBrandForId(id);
            brand.setDescription(brandNew.getDescription());
            brandService.saveBrand(brand);
            response.put("message","The Brand has been edited correctly.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "The category could not be edited");
            return ResponseEntity.badRequest().body(response);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteBrand(@PathVariable Long id){
        Map<String,String> response = new HashMap<>();
        try{
            Brand brand = brandService.serchBrandForId(id);
            brandService.deleteBrand(brand);
            response.put("message", "Brand successfully removed");
            return ResponseEntity.ok(response);
        } catch (Exception e){
            response.put("message", "The Brand could not be deleted");
            return ResponseEntity.badRequest().body(response);
            
        }
    }
        


}

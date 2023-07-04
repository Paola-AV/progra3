package com.sad.demo.controllers;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sad.demo.models.PropiedadModel;
import com.sad.demo.services.PropiedadService;

@RestController
@RequestMapping("/propiedad")
public class PropiedadController {
     @Autowired
    private PropiedadService PropiedadService;
    
    @GetMapping
    public ArrayList<PropiedadModel>getPropiedad(){
    return this.PropiedadService.getPropiedad();}
    
    @PostMapping
    public PropiedadModel savePropiedad(@RequestBody PropiedadModel propiedad){
    return this.PropiedadService.savePropiedad(propiedad);
    }
    
    @GetMapping(path="/{IDpropiedad}")
    public Optional <PropiedadModel> getPropiedadbyId(@PathVariable Long IDpropiedad){
        return this.PropiedadService.getbyId(IDpropiedad);
    }
    
    @PutMapping(path="/{IDpropiedad}")
    public PropiedadModel updateById(@RequestBody PropiedadModel request,@PathVariable("IDpropiedad") Long IDpropiedad ){
    return this.PropiedadService.updateById(request, IDpropiedad);
    }
    
    @DeleteMapping(path="/{IDpropiedad}")
    public String deleteById(@PathVariable("IDpropiedad") Long IDpropiedad){
            boolean ok = this.PropiedadService.deletePropiedad(IDpropiedad);
            if(ok){
                return "La propiedad con el ID "+IDpropiedad+" ha sido eliminado";
            }else{
                return "Hubo un problema y la propiedad con el ID "+IDpropiedad+" no ha podido ser eliminado";
            }
    }
}

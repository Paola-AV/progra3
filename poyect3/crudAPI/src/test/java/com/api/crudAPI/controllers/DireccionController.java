package com.api.crudAPI.controllers;

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
import com.api.crudAPI.models.DireccionModel;
import com.api.crudAPI.services.DireccionService;

@RestController
@RequestMapping("/direccion")
public class DireccionController {
     
    @Autowired
    private DireccionService DireccionService;
    
    @GetMapping
    public ArrayList<DireccionModel>getDireccion(){
    return this.DireccionService.getDireccion();}
    
    @PostMapping
    public DireccionModel saveDireccion(@RequestBody DireccionModel direccion){
    return this.DireccionService.saveDireccion(direccion);
    }
    
    @GetMapping(path="/{IDdireccion}")
    public Optional <DireccionModel> getDireccionbyId(@PathVariable Long IDdireccion){
        return this.DireccionService.getbyId(IDdireccion);
    }
    
    @PutMapping(path="/{IDdireccion}")
    public DireccionModel updateById(@RequestBody DireccionModel request,@PathVariable("IDdireccion") Long IDdireccion ){
    return this.DireccionService.updateById(request, IDdireccion);
    }
    
    @DeleteMapping(path="/{IDdireccion}")
    public String deleteById(@PathVariable("IDdireccion") Long IDdireccion){
            boolean ok = this.DireccionService.deleteDireccion(IDdireccion);
            if(ok){
                return "La direccion con el ID "+IDdireccion+" ha sido eliminado";
            }else{
                return "Hubo un problema y la direccion con el ID "+IDdireccion+" no ha podido ser eliminado";
            }
    }
}

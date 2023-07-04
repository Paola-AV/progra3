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

import com.sad.demo.models.FiadorModel;
import com.sad.demo.services.FiadorService;
@RestController
@RequestMapping("/fiador")
public class FiadorController {
    @Autowired
    private FiadorService FiadorService;
    
    @GetMapping
    public ArrayList<FiadorModel>getFiador(){
    return this.FiadorService.getFiador();}
    
    @PostMapping
    public FiadorModel saveFiador(@RequestBody FiadorModel fiador){
    return this.FiadorService.saveFiador(fiador);
    }
    
    @GetMapping(path="/{IDfiador}")
    public Optional <FiadorModel> getFiadorbyId(@PathVariable Long IDfiador){
        return this.FiadorService.getbyId(IDfiador);
    }
    
    @PutMapping(path="/{IDfiador}")
    public FiadorModel updateById(@RequestBody FiadorModel request,@PathVariable("IDfiador") Long IDfiador){
    return this.FiadorService.updateById(request, IDfiador);
    }
    
    @DeleteMapping(path="/{IDfiador}")
    public String deleteById(@PathVariable("IDfiador") Long IDfiador){
            boolean ok = this.FiadorService.deleteFiador(IDfiador);
            if(ok){
                return "El Fiador con el ID "+IDfiador+" ha sido eliminado";
            }else{
                return "Hubo un problema y el fiador con el ID "+IDfiador+" no ha podido ser eliminado";
            }
    }
    
}

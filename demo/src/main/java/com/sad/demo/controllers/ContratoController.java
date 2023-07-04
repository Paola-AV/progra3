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

import com.sad.demo.models.ContratoModel;
import com.sad.demo.services.ContratoService;
@RestController
@RequestMapping("/contrato")
public class ContratoController {
     @Autowired
    private ContratoService contratoService;

    @GetMapping
    public ArrayList<ContratoModel>getContrato(){
    return this.contratoService.getContrato();}
    
    @PostMapping
    public ContratoModel saveContrato(@RequestBody ContratoModel contrato){
    return this.contratoService.saveContrato(contrato);
    }
    
    @GetMapping(path="/{IDcontrato}")
    public Optional <ContratoModel> getContratobyId(@PathVariable Long IDcontrato){
        return this.contratoService.getbyId(IDcontrato);
    }
    
    @PutMapping(path="/{IDcontrato}")
    public ContratoModel updateById(@RequestBody ContratoModel request,@PathVariable("IDcontrato") Long IDcontrato ){
    return this.contratoService.updateById(request, IDcontrato);
    }
    
    @DeleteMapping(path="/{IDcontrato}")
    public String deleteById(@PathVariable("IDcontrato") Long IDcontrato){
            boolean ok = this.contratoService.deleteContrato(IDcontrato);
            if(ok){
                return "Cliente con el ID "+IDcontrato+" ha sido eliminado";
            }else{
                return "Hubo un problema y el cliente con el ID "+IDcontrato+" no ha podido ser eliminado";
            }
    }
}

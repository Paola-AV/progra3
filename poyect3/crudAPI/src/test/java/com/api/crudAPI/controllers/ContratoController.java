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

import com.api.crudAPI.models.ClienteModel;
import com.api.crudAPI.services.ClienteServicio;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
    @Autowired
    private ClienteServicio ClienteServicio;
    
    @GetMapping
    public ArrayList<ClienteModel>getCliente(){
    return this.ClienteServicio.getCliente();}
    
    @PostMapping
    public ClienteModel saveCliente(@RequestBody ClienteModel cliente){
    return this.ClienteServicio.saveCliente(cliente);
    }
    
    @GetMapping(path="/{IDcliente}")
    public Optional <ClienteModel> getClientebyId(@PathVariable Long IDcliente){
        return this.ClienteServicio.getbyId(IDcliente);
    }
    
    @PutMapping(path="/{IDcliente}")
    public ClienteModel updateById(@RequestBody ClienteModel request,@PathVariable("IDcliente") Long IDcliente ){
    return this.ClienteServicio.updateById(request, IDcliente);
    }
    
    @DeleteMapping(path="/{IDcliente}")
    public String deleteById(@PathVariable("IDcliente") Long IDcliente){
            boolean ok = this.ClienteServicio.deleteCliente(IDcliente);
            if(ok){
                return "Cliente con el ID "+IDcliente+" ha sido eliminado";
            }else{
                return "Hubo un problema y el cliente con el ID "+IDcliente+" no ha podido ser eliminado";
            }
    }
    
}

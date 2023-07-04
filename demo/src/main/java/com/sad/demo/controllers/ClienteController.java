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

import com.sad.demo.models.ClienteModel;
import com.sad.demo.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
     @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ArrayList<ClienteModel>getCliente(){
    return this.clienteService.getCliente();}
    
    @PostMapping
    public ClienteModel saveCliente(@RequestBody ClienteModel cliente){
    return this.clienteService.saveCliente(cliente);
    }
    
    @GetMapping(path="/{IDcliente}")
    public Optional <ClienteModel> getClientebyId(@PathVariable Long IDcliente){
        return this.clienteService.getbyId(IDcliente);
    }
    
    @PutMapping(path="/{IDcliente}")
    public ClienteModel updateById(@RequestBody ClienteModel request,@PathVariable("IDcliente") Long IDcliente ){
    return this.clienteService.updateById(request, IDcliente);
    }
    
    @DeleteMapping(path="/{IDcliente}")
    public String deleteById(@PathVariable("IDcliente") Long IDcliente){
            boolean ok = this.clienteService.deleteCliente(IDcliente);
            if(ok){
                return "Cliente con el ID "+IDcliente+" ha sido eliminado";
            }else{
                return "Hubo un problema y el cliente con el ID "+IDcliente+" no ha podido ser eliminado";
            }
    }
}


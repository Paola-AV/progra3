package com.api.crudAPI.controllers;


import com.api.crudAPI.models.UsuarioModel;
import com.api.crudAPI.services.UsuarioService;
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

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService UsuarioService;
    
    @GetMapping
    public ArrayList<UsuarioModel>getUsuario(){
    return this.UsuarioService.getUsuario();}
    
    @PostMapping
    public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuario){
    return this.UsuarioService.saveUsuario(usuario);
    }
    
    @GetMapping(path="/{IDusuario}")
    public Optional <UsuarioModel> getUsuariobyId(@PathVariable Long IDusuario){
        return this.UsuarioService.getbyId(IDusuario);
    }
    
    @PutMapping(path="/{IDusuario}")
    public UsuarioModel updateById(@RequestBody UsuarioModel request,@PathVariable("IDusuario") Long IDusuario ){
    return this.UsuarioService.updateById(request,IDusuario);
    }
    
    @DeleteMapping(path="/{IDusuario}")
    public String deleteById(@PathVariable("IDusuario") Long IDusuario){
            boolean ok = this.UsuarioService.deleteUsuario(IDusuario);
            if(ok){
                return "Usuario con el ID "+IDusuario+" ha sido eliminado";
            }else{
                return "Hubo un problema y el usuario con el ID "+IDusuario+" no ha podido ser eliminado";
            }
    }
}

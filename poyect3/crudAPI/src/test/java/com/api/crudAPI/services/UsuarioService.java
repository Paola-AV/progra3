package com.api.crudAPI.services;


import com.api.crudAPI.models.UsuarioModel;
import com.api.crudAPI.repositories.IUsuarioRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
     @Autowired
    IUsuarioRepository usuarioRepository;

     public ArrayList<UsuarioModel> getUsuario(){
        return(ArrayList<UsuarioModel>)usuarioRepository.findAll();
    }
    
    public UsuarioModel saveUsuario(UsuarioModel usuario){
    return usuarioRepository.save(usuario);
    }
    
    public Optional<UsuarioModel>getbyId(Long IDusuario){
    return usuarioRepository.findById(IDusuario);
    }
    
   public UsuarioModel updateById(UsuarioModel request, Long IDusuario){
   UsuarioModel usuario = usuarioRepository.findById(IDusuario).get();
   usuario.setNombre(request.getNombre());
   usuario.setApellido(request.getApellido());
   usuario.setContraseña(request.getContraseña());
   usuario.setTipo(request.getTipo());
   
   return usuario;
   }
   
   public Boolean deleteUsuario (Long IDusuario){
   try{usuarioRepository.deleteById(IDusuario);
   return true;
   }catch(Exception e){return false;}
   }
}

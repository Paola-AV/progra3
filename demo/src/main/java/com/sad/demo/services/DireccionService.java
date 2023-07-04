package com.sad.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sad.demo.Repository.IDireccionRepository;
import com.sad.demo.models.DireccionModel;

@Service
public class DireccionService {
    @Autowired
    IDireccionRepository direccionRepository;

    
    public ArrayList<DireccionModel> getDireccion(){
        return(ArrayList<DireccionModel>)direccionRepository.findAll();
    }
    
    public DireccionModel saveDireccion(DireccionModel direccion){
    return direccionRepository.save(direccion);
    }
    
    public Optional<DireccionModel>getbyId(Long IDdireccion){
    return direccionRepository.findById(IDdireccion);
    }
    
   public DireccionModel updateById(DireccionModel request, Long IDdireccion){
   DireccionModel direccion = direccionRepository.findById(IDdireccion).get();
   direccion.setProvincia(request.getProvincia());
   direccion.setDistrito(request.getDistrito());
   direccion.setCanton(request.getCanton());
   direccion.setSeñales(request.getSeñales());

   
   return direccion;
   }
   
   public Boolean deleteDireccion (Long IDdireccion){
   try{direccionRepository.deleteById(IDdireccion);
   return true;
   }catch(Exception e){return false;}
   }
}

package com.sad.demo.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sad.demo.Repository.IPropiedadRepository;
import com.sad.demo.models.PropiedadModel;


@Service
public class PropiedadService {
    @Autowired
    IPropiedadRepository propiedadRepository;
    
    public ArrayList<PropiedadModel> getPropiedad(){
        return(ArrayList<PropiedadModel>)propiedadRepository.findAll();
    }
    
    public PropiedadModel savePropiedad(PropiedadModel propiedad){
    return propiedadRepository.save(propiedad);
    }
    
    public Optional<PropiedadModel>getbyId(Long IDpropiedad){
    return propiedadRepository.findById(IDpropiedad);
    }
    
   public PropiedadModel updateById(PropiedadModel request, Long IDpropiedad){
   PropiedadModel propiedad = propiedadRepository.findById(IDpropiedad).get();
   propiedad.setDescripcion(request.getDescripcion());
   propiedad.setPrecio(request.getPrecio());
   propiedad.setTipo(request.getTipo());
   propiedad.setIDdireccion(request.getIDdireccion());
   
   return propiedad;
   }
   
   public Boolean deletePropiedad (Long IDpropiedad){
   try{propiedadRepository.deleteById(IDpropiedad);
   return true;
   }catch(Exception e){return false;}
   }
}

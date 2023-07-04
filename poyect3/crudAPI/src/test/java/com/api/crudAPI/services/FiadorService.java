package com.api.crudAPI.services;


import com.api.crudAPI.models.FiadorModel;
import com.api.crudAPI.repositories.IFiadorRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FiadorService {
 
    @Autowired
    IFiadorRepository fiadorRepository;

    public ArrayList<FiadorModel> getFiador(){
        return(ArrayList<FiadorModel>)fiadorRepository.findAll();
    }
    
    public FiadorModel saveFiador(FiadorModel fiador){
    return fiadorRepository.save(fiador);
    }
    
    public Optional<FiadorModel>getbyId(Long IDfiador){
    return fiadorRepository.findById(IDfiador);
    }
    
   public FiadorModel updateById(FiadorModel request, Long IDfiador){
   FiadorModel fiador = fiadorRepository.findById(IDfiador).get();
   fiador.setNombre(request.getNombre());
   fiador.setApellido(request.getApellido());
   fiador.setTelefono(request.getTelefono());
   fiador.setGmail(request.getGmail());
   
   return fiador;
   }
   
   public Boolean deleteFiador (Long IDfiador){
   try{fiadorRepository.deleteById(IDfiador);
   return true;
   }catch(Exception e){return false;}    

}}

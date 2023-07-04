package com.api.crudAPI.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crudAPI.models.ContratoModel;
import com.api.crudAPI.repositories.IContratoRepository;

@Service
public class ContratoService {
     @Autowired
    IContratoRepository contratoRepository;
    
    public ArrayList<ContratoModel> getContrato(){
        return(ArrayList<ContratoModel>)contratoRepository.findAll();
    }
    
    public ContratoModel saveContrato(ContratoModel contrato){
    return contratoRepository.save(contrato);
    }
    
    public Optional<ContratoModel>getbyId(Long IDcontrato){
    return contratoRepository.findById(IDcontrato);
    }
    
   public ContratoModel updateById(ContratoModel request, Long IDcontrato){
   ContratoModel contrato = contratoRepository.findById(IDcontrato).get();
   contrato.setFechaPago(request.getFechaPago());
   contrato.setIDcliente(request.getIDcliente());
   contrato.setIDpropiedad(request.getIDpropiedad());
   
   return contrato;
   }
   
   public Boolean deleteContrato (Long IDcontrato){
   try{contratoRepository.deleteById(IDcontrato);
   return true;
   }catch(Exception e){return false;}
   }
    
}

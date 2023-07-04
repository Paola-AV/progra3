package com.sad.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sad.demo.Repository.IClienteRepository;
import com.sad.demo.models.ClienteModel;

@Service
public class ClienteService {
    @Autowired
    IClienteRepository clienteRepository;
    public ArrayList<ClienteModel> getCliente(){
        return(ArrayList<ClienteModel>)clienteRepository.findAll();
    }
    
    public ClienteModel saveCliente(ClienteModel cliente){
    return clienteRepository.save(cliente);
    }
    
    public Optional<ClienteModel>getbyId(Long IDcliente){
    return clienteRepository.findById(IDcliente);
    }
    
   public ClienteModel updateById(ClienteModel request, Long IDcliente){
   ClienteModel cliente = clienteRepository.findById(IDcliente).get();
   cliente.setNombre(request.getNombre());
   cliente.setApellido(request.getApellido());
   cliente.setTelefono(request.getTelefono());
   cliente.setGmail(request.getGmail());
   cliente.setIDfiador(request.getIDfiador());
   
   return cliente;
   }
   
   public Boolean deleteCliente (Long IDcliente){
   try{clienteRepository.deleteById(IDcliente);
   return true;
   }catch(Exception e){return false;}
   }
    
}

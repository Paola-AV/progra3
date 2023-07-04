package com.api.crudAPI.repositories;


import com.api.crudAPI.models.FiadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IFiadorRepository extends JpaRepository<FiadorModel, Long>{
    
}

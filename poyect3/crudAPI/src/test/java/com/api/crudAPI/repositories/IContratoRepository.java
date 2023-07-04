package com.api.crudAPI.repositories;

import com.api.crudAPI.models.ContratoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IContratoRepository extends JpaRepository<ContratoModel, Long>  {
    
}

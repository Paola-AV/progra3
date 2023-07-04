package com.api.crudAPI.repositories;


import com.api.crudAPI.models.PropiedadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropiedadRepository extends JpaRepository<PropiedadModel, Long> {
    
}

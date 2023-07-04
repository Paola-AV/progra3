package com.api.crudAPI.repositories;

import com.api.crudAPI.models.DireccionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IDireccionRepository extends JpaRepository<DireccionModel, Long> {
    
}

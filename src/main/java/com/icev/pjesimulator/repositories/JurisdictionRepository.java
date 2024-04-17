package com.icev.pjesimulator.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icev.pjesimulator.models.Jurisdiction;

@Repository
public interface JurisdictionRepository extends JpaRepository<Jurisdiction, Long> {

    
    @Query("SELECT ju FROM Jurisdiction ju LEFT JOIN JudiciaryClasses jc on ju.id=jc.id INNER JOIN Matter m on m.id = :id")
    List<Jurisdiction> findByMatterId(Long id);
} 

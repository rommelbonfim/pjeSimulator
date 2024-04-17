package com.icev.pjesimulator.repositories;


import com.icev.pjesimulator.models.AuxilarClassAttorneyProcess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Attorney_ProcessRepository extends JpaRepository<AuxilarClassAttorneyProcess, Long> {

} 

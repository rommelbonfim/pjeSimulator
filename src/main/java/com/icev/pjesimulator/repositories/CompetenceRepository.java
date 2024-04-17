package com.icev.pjesimulator.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icev.pjesimulator.models.Competence;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {

    @Query(value = "SELECT * FROM competence c WHERE c.jurisdiction_id = ?1 AND c.judiciary_class_id = ?2", nativeQuery=true)
    Competence findByJurisdictionJudiciary(Long idJurisdiction, Long idJudiciaryClass);
}

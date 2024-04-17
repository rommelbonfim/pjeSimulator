package com.icev.pjesimulator.repositories;

import com.icev.pjesimulator.models.JudiciaryClasses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JudiciaryClassesRepository extends JpaRepository<JudiciaryClasses, Long> {
	
	//SELECT ju FROM judiciary_classes ju INNER JOIN matter ma on matter_id = ma.id WHERE matter_id = 2
	@Query("SELECT ju FROM JudiciaryClasses ju INNER JOIN Matter m on m.id = ju.matter.id WHERE m.id = :id")
	List<JudiciaryClasses> findByMatterId(Long id);
}

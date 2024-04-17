package com.icev.pjesimulator.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.icev.pjesimulator.models.Help;

@Repository
public interface HelpRepository extends JpaRepository<Help, Long> {
	
	@Transactional
	Optional<Help> findByKey(String key);
}

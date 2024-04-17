package com.icev.pjesimulator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icev.pjesimulator.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
}

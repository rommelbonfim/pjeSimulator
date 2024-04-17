package com.icev.pjesimulator.repositories;

import java.util.Optional;

import com.icev.pjesimulator.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	Optional<Profile> findByCpf(String cpf);
	
}

package com.icev.pjesimulator.repositories;

import com.icev.pjesimulator.models.JudiciaryClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icev.pjesimulator.models.Address;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT ad FROM Address ad INNER JOIN Person p on p.id = ad.person.id WHERE p.id = :id")
    List<Address> findByPersonId(Long id);
	
}

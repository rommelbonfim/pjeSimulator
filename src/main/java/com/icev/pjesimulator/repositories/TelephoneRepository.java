package com.icev.pjesimulator.repositories;

import com.icev.pjesimulator.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icev.pjesimulator.models.Telephone;

import java.util.List;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {

    @Query("SELECT tl FROM Telephone tl INNER JOIN Person p on p.id = tl.person.id WHERE p.id = :id")
    List<Telephone> findByPersonId(Long id);
	
}

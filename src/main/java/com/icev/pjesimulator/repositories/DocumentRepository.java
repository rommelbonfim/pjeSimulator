package com.icev.pjesimulator.repositories;

import com.icev.pjesimulator.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icev.pjesimulator.models.Document;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query("SELECT dc FROM Document dc INNER JOIN Person p on p.id = dc.person.id WHERE p.id = :id")
    List<Document> findByPersonId(Long id);
	
}

package com.icev.pjesimulator.repositories;


import com.icev.pjesimulator.models.Attorney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttorneyRepository extends JpaRepository<Attorney, Long> {

}

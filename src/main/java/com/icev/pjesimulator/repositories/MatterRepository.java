package com.icev.pjesimulator.repositories;

import com.icev.pjesimulator.models.Matter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatterRepository extends JpaRepository<Matter, Long> {

}

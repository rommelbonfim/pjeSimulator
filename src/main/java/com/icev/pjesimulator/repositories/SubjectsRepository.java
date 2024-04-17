package com.icev.pjesimulator.repositories;

import com.icev.pjesimulator.models.Subjects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Long> {
    Page<Subjects> findAll(Pageable pagination);
} 

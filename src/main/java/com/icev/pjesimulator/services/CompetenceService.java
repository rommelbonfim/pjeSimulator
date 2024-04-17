package com.icev.pjesimulator.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.icev.pjesimulator.repositories.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icev.pjesimulator.dto.CompetenceDto;
import com.icev.pjesimulator.form.CompetenceForm;
import com.icev.pjesimulator.models.Competence;
import com.icev.pjesimulator.repositories.CompetenceRepository;
import com.icev.pjesimulator.repositories.JudiciaryClassesRepository;
import com.icev.pjesimulator.repositories.JurisdictionRepository;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;

@Service
public class CompetenceService {
	
	@Autowired
	JudiciaryClassesRepository judClassRepo;
	
	@Autowired
	JurisdictionRepository jurRepo;
	
	@Autowired
	CompetenceRepository compRepo;

	public CompetenceDto insert(CompetenceForm form) {
		Competence competence = new Competence();
		
		competence.setJudiciaryClass(judClassRepo.findById(form.getJudiciaryClassId()).get());
		competence.setJurisdiction(jurRepo.findById(form.getJurisdictionId()).get());
		compRepo.save(competence);
		return new CompetenceDto(competence.getId());
	}

	public List<Competence> findAll() {
		return compRepo.findAll();
	}
	
	public CompetenceDto findById(Long id) {
		Optional<Competence> obj = compRepo.findById(id);
		Competence competence = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new CompetenceDto(competence.getId());
	}
	
	@Transactional
	public CompetenceDto update(Long id, CompetenceForm form) {
		Competence competence = compRepo.findById(id).get();
		competence.setJudiciaryClass(judClassRepo.findById(form.getJudiciaryClassId()).get());
		competence.setJurisdiction(jurRepo.findById(form.getJurisdictionId()).get());
		compRepo.save(competence);
		return new CompetenceDto(competence.getId());

	}

	public void delete(Long id) {
		try {
			findById(id);
			compRepo.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Id not found to delete");
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException("Empty search result");
		}
	}
	
	public CompetenceDto fromCompetence(Competence entity) {
		return new CompetenceDto(entity.getId());
	}

	public CompetenceDto findByJuridictionJudiciaryClass(Long idJurisdiction, Long idJudiciaryClass) {
		Competence competence = compRepo.findByJurisdictionJudiciary(idJurisdiction, idJudiciaryClass);
		CompetenceDto dto = CompetenceDto.fromCompetence(competence);
		return dto;
	}
}

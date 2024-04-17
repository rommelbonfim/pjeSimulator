package com.icev.pjesimulator.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icev.pjesimulator.dto.JurisdictionDto;
import com.icev.pjesimulator.form.JurisdictionForm;
import com.icev.pjesimulator.models.Jurisdiction;
import com.icev.pjesimulator.repositories.JurisdictionRepository;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;

@Service
public class JurisdictionService {

	@Autowired
	private JurisdictionRepository repository;

	@Autowired
	private JurisdictionRepository jurisdictionRepository;

	@Transactional
	public JurisdictionDto insert(JurisdictionForm form) {
		Jurisdiction entity = new Jurisdiction();
		entity.setDescription(form.getDescription());
		entity = repository.save(entity);
		return new JurisdictionDto(entity);
	}

	public JurisdictionDto findById(Long id) {
		Optional<Jurisdiction> obj = repository.findById(id);
		Jurisdiction entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new JurisdictionDto(entity);
	}

	public List<Jurisdiction> findAll() {
		return repository.findAll();
	}

	@Transactional
	public JurisdictionDto update(Long id, JurisdictionForm form) {
		Jurisdiction entity = repository.getById(id);
		entity.setDescription(form.getDescription());
		entity = repository.save(entity);
		return new JurisdictionDto(entity);

	}

	public void delete(Long id) {
		try {
			findById(id);
			repository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Id not found to delete");
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException("Empty search result");
		}
	}

	public JurisdictionDto fromJurisdiction(Jurisdiction entity) {
		return new JurisdictionDto(entity.getId(), entity.getDescription());
	}

	public List<JurisdictionDto> findByMatterId(Long id) {
		List<Jurisdiction> list = jurisdictionRepository.findByMatterId(id);
		return list.stream().map(this::fromJurisdiction)
				.collect(Collectors.toList());
	}
}

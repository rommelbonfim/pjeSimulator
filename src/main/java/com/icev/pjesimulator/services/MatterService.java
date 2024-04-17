package com.icev.pjesimulator.services;

import com.icev.pjesimulator.dto.MatterDto;
import com.icev.pjesimulator.form.MatterForm;
import com.icev.pjesimulator.models.Matter;
import com.icev.pjesimulator.repositories.MatterRepository;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MatterService {

	@Autowired
	private MatterRepository repository;

	@Transactional
	public MatterDto insert(MatterForm form) {
		Matter entity = new Matter();
		entity.setDescription(form.getDescription());
		entity = repository.save(entity);
		return new MatterDto(entity);
	}

	public MatterDto findById(Long id) {
		Optional<Matter> obj = repository.findById(id);
		Matter entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MatterDto(entity);
	}

	public List<Matter> findAll() {
		return repository.findAll();
	}

	@Transactional
	public MatterDto update(Long id, MatterForm form) {
		Matter entity = repository.getById(id);
		entity.setDescription(form.getDescription());
		entity = repository.save(entity);
		return new MatterDto(entity.getId(), entity.getDescription());

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

	public MatterDto fromMatter(Matter matter) {
		return new MatterDto(matter.getId(), matter.getDescription());
	}
}

package com.icev.pjesimulator.services;

import com.icev.pjesimulator.dto.SubjectsDto;
import com.icev.pjesimulator.form.SubjectsForm;
import com.icev.pjesimulator.models.Subjects;
import com.icev.pjesimulator.repositories.SubjectsRepository;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectsService {

	@Autowired
	private SubjectsRepository subjectsRepository;

	@Transactional
	public SubjectsDto insert(SubjectsForm form) {
		Subjects entity = new Subjects();
		entity.setCodigo(form.getCodigo());
		entity.setComplement(form.getComplement());
		entity = subjectsRepository.save(entity);
		return new SubjectsDto(entity);
	}

	public SubjectsDto findById(Long id) {
		Optional<Subjects> obj = subjectsRepository.findById(id);
		Subjects entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new SubjectsDto(entity);
	}
	public Page<Subjects> findAll(Pageable pagination){
		return subjectsRepository.findAll(pagination);
	}


	@Transactional
	public SubjectsDto update(Long id, SubjectsForm form) {
		Subjects entity = subjectsRepository.getById(id);
		entity.setCodigo(form.getCodigo());
		entity.setComplement(form.getComplement());
		entity = subjectsRepository.save(entity);
		return new SubjectsDto(entity.getId(), entity.getCodigo(), entity.getComplement());

	}

	public void delete(Long id) {
		try {
			findById(id);
			subjectsRepository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Id not found to delete");
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException("Empty search result");
		}

	}

	public SubjectsDto fromSubjects(Subjects subjects) {
		return new SubjectsDto(subjects.getId(), subjects.getCodigo(),subjects.getComplement());
	}
}

package com.icev.pjesimulator.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.icev.pjesimulator.dto.DocumentDto;
import com.icev.pjesimulator.models.Document;
import com.icev.pjesimulator.models.Person;
import com.icev.pjesimulator.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icev.pjesimulator.dto.TelephoneDto;
import com.icev.pjesimulator.form.TelephoneForm;
import com.icev.pjesimulator.models.Telephone;
import com.icev.pjesimulator.repositories.TelephoneRepository;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;

@Service
public class TelephoneService {

	@Autowired
	private TelephoneRepository repository;

	@Autowired
	private PersonRepository personRepository;

	@Transactional
	public TelephoneDto insert(TelephoneForm form) {
		Telephone entity = new Telephone();
		entity.setType(form.getType());
		entity.setNumber(form.getNumber());
		Person person = personRepository.findById(form.getPerson_id()).get();
		person.getTelephones().add(entity);
		entity.setPerson(person);
		entity = repository.save(entity);
		return new TelephoneDto(entity);
	}

	public TelephoneDto findById(Long id) {
		Optional<Telephone> obj = repository.findById(id);
		Telephone entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new TelephoneDto(entity);
	}

	public List<Telephone> findAll() {
		return repository.findAll();
	}

	@Transactional
	public TelephoneDto update(Long id, TelephoneForm form) {
		Telephone entity = repository.getById(id);
		entity.setType(form.getType());
		entity.setNumber(form.getNumber());
		entity = repository.save(entity);
		return new TelephoneDto(entity);

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

	public List<TelephoneDto> findByPersonId(Long id) {
		List<Telephone> list = repository.findByPersonId(id);
		return list.stream().map(this::fromTelephone)
				.collect(Collectors.toList());
	}

	public TelephoneDto fromTelephone(Telephone telephone) {
		return new TelephoneDto(telephone);
	}
}

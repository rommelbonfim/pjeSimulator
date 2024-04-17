package com.icev.pjesimulator.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.icev.pjesimulator.dto.JudiciaryClassesDto;
import com.icev.pjesimulator.models.JudiciaryClasses;
import com.icev.pjesimulator.models.Person;
import com.icev.pjesimulator.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icev.pjesimulator.dto.AddressDto;
import com.icev.pjesimulator.dto.MatterDto;
import com.icev.pjesimulator.form.AddressForm;
import com.icev.pjesimulator.form.MatterForm;
import com.icev.pjesimulator.models.Address;
import com.icev.pjesimulator.models.Matter;
import com.icev.pjesimulator.repositories.AddressRepository;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	@Autowired
	private PersonRepository personRepository;

	@Transactional
	public AddressDto insert(AddressForm form) {
		Address entity = new Address();
		entity.setCep(form.getCep());
		entity.setState(form.getState());
		entity.setCity(form.getCity());
		entity.setDistrict(form.getDistrict());
		entity.setStreet(form.getDistrict());
		entity.setNumber(form.getNumber());
		entity.setComplement(form.getComplement());
		entity.setUseInProcess(form.isUseInProcess());
		Person person = personRepository.findById(form.getPerson_id()).get();
		person.getAddresses().add(entity);
		entity.setPerson(person);
		entity = repository.save(entity);
		return new AddressDto(entity);
	}

	public AddressDto findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		Address entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new AddressDto(entity);
	}

	public List<Address> findAll() {
		return repository.findAll();
	}

	@Transactional
	public AddressDto update(Long id, AddressForm form) {
		Address entity = repository.getById(id);
		entity.setCep(form.getCep());
		entity.setState(form.getState());
		entity.setCity(form.getCity());
		entity.setDistrict(form.getDistrict());
		entity.setStreet(form.getDistrict());
		entity.setNumber(form.getNumber());
		entity.setComplement(form.getComplement());
		entity.setUseInProcess(form.isUseInProcess());
		Person person = personRepository.findById(form.getPerson_id()).get();
		entity.setPerson(person);
		entity = repository.save(entity);
		return new AddressDto(entity);

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

	public List<AddressDto> findByPersonId(Long id) {
		List<Address> list = repository.findByPersonId(id);
		return list.stream().map(this::fromAddress)
				.collect(Collectors.toList());
	}

	public AddressDto fromAddress(Address address) {return new AddressDto(address);}
}

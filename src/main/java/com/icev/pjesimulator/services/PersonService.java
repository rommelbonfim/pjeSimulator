package com.icev.pjesimulator.services;

import com.icev.pjesimulator.dto.PersonDto;
import com.icev.pjesimulator.form.PersonForm;
import com.icev.pjesimulator.models.Person;
import com.icev.pjesimulator.repositories.PersonRepository;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    @Transactional
    public PersonDto insert(PersonForm form) {
        Person person = form.toPerson(form);
        return new PersonDto(repository.save(person));
    }

    public PersonDto findById(Long id) {
        Optional<Person> obj = repository.findById(id);
        Person entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PersonDto(entity);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    @Transactional
    public PersonDto update(Long id, PersonForm form) {
        Person entity = repository.getById(id);
        entity.setEstrangeiro(form.isEstrangeiro());
        entity.setCpf(form.getCpf());
        entity.setCnpj(form.getCnpj());
        entity = repository.save(entity);
        return new PersonDto(entity);

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

    public PersonDto fromPerson(Person person) {return new PersonDto(person);}




}

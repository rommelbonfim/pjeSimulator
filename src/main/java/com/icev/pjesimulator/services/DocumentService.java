package com.icev.pjesimulator.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.icev.pjesimulator.dto.AddressDto;
import com.icev.pjesimulator.models.Address;
import com.icev.pjesimulator.models.Person;
import com.icev.pjesimulator.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icev.pjesimulator.dto.DocumentDto;
import com.icev.pjesimulator.form.DocumentForm;
import com.icev.pjesimulator.models.Document;
import com.icev.pjesimulator.repositories.DocumentRepository;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;
import com.icev.pjesimulator.utils.Utils;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository repository;

	@Autowired
	private PersonRepository personRepository;

	@Transactional
	public DocumentDto insert(DocumentForm form) {
		Document entity = new Document();
		entity.setType(form.getType());
		entity.setNumber(form.getNumber());
		entity.setExpedition_date(Utils.parse(form.getExpedition_date()));
		entity.setExpeditor(form.getExpeditor());
		entity.setState(form.getState());
		entity.setNome(form.getNome());
		Person person = personRepository.findById(form.getPerson_id()).get();
		person.getDocuments().add(entity);
		entity.setPerson(person);
		entity = repository.save(entity);
		return new DocumentDto(entity);
	}

	public DocumentDto findById(Long id) {
		Optional<Document> obj = repository.findById(id);
		Document entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new DocumentDto(entity);
	}

	public List<Document> findAll() {
		return repository.findAll();
	}

	@Transactional
	public DocumentDto update(Long id, DocumentForm form) {
		Document entity = repository.getById(id);
		entity.setType(form.getType());
		entity.setNumber(form.getNumber());
		entity.setExpedition_date(Utils.parse(form.getExpedition_date()));
		entity.setExpeditor(form.getExpeditor());
		entity.setState(form.getState());
		entity.setNome(form.getNome());
		entity = repository.save(entity);
		return new DocumentDto(entity);

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

	public List<DocumentDto> findByPersonId(Long id) {
		List<Document> list = repository.findByPersonId(id);
		return list.stream().map(this::fromMatter)
				.collect(Collectors.toList());
	}

	public DocumentDto fromMatter(Document document) {
		return new DocumentDto(document);
	}
}

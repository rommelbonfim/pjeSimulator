package com.icev.pjesimulator.controllers;

import java.util.List;

import com.icev.pjesimulator.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.icev.pjesimulator.dto.DocumentDto;
import com.icev.pjesimulator.form.DocumentForm;
import com.icev.pjesimulator.models.Document;
import com.icev.pjesimulator.services.DocumentService;

@RestController
@RequestMapping(value="/document")
public class DocumentController {
	
	@Autowired
	private DocumentService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<DocumentDto> findById(@PathVariable Long id) {
		
		DocumentDto obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/person/{id}")
	public ResponseEntity<List<DocumentDto>> findByPersonId(@PathVariable Long id) {
		List<DocumentDto> dto = service.findByPersonId(id);
		return ResponseEntity.ok().body(dto);
	}

	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Document>> findAll() {
		
		List<Document> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<DocumentDto> insert(@RequestBody DocumentForm form) {
				
		DocumentDto dto = service.insert(form);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<DocumentDto> update(@RequestBody DocumentForm form, @PathVariable Long id) {
		
		DocumentDto dto = service.update(id, form);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}

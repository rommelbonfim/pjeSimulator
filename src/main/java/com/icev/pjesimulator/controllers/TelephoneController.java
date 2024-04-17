package com.icev.pjesimulator.controllers;

import java.util.List;

import com.icev.pjesimulator.dto.DocumentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.icev.pjesimulator.dto.TelephoneDto;
import com.icev.pjesimulator.form.TelephoneForm;
import com.icev.pjesimulator.models.Telephone;
import com.icev.pjesimulator.services.TelephoneService;

@RestController
@RequestMapping(value="/telephone")
public class TelephoneController {
	
	@Autowired
	private TelephoneService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TelephoneDto> findById(@PathVariable Long id) {
		
		TelephoneDto obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/person/{id}")
	public ResponseEntity<List<TelephoneDto>> findByPersonId(@PathVariable Long id) {
		List<TelephoneDto> dto = service.findByPersonId(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Telephone>> findAll() {
		
		List<Telephone> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<TelephoneDto> insert(@RequestBody TelephoneForm form) {
				
		TelephoneDto dto = service.insert(form);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<TelephoneDto> update(@RequestBody TelephoneForm form, @PathVariable Long id) {
		
		TelephoneDto dto = service.update(id, form);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}

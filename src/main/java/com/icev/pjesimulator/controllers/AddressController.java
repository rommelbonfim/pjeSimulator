package com.icev.pjesimulator.controllers;

import java.util.List;

import com.icev.pjesimulator.dto.JudiciaryClassesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.icev.pjesimulator.dto.AddressDto;
import com.icev.pjesimulator.form.AddressForm;
import com.icev.pjesimulator.models.Address;
import com.icev.pjesimulator.services.AddressService;

@RestController
@RequestMapping(value="/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AddressDto> findById(@PathVariable Long id) {
		
		AddressDto obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/person/{id}")
	public ResponseEntity<List<AddressDto>> findByPersonId(@PathVariable Long id) {
		List<AddressDto> dto = service.findByPersonId(id);
		return ResponseEntity.ok().body(dto);
	}

	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Address>> findAll() {
		
		List<Address> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<AddressDto> insert(@RequestBody AddressForm form) {
				
		AddressDto addressDto = service.insert(form);
	
		return ResponseEntity.ok().body(addressDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<AddressDto> update(@RequestBody AddressForm form, @PathVariable Long id) {
		
		
		AddressDto addressDto = service.update(id, form);
		
		return ResponseEntity.ok().body(addressDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}

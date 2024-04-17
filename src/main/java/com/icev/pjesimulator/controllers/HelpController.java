package com.icev.pjesimulator.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.icev.pjesimulator.models.Help;
import com.icev.pjesimulator.services.HelpService;

@RestController
@RequestMapping(value="/help")
public class HelpController {
	
	@Autowired
	private HelpService helpService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Help> findById(@PathVariable Long id) {
		
		Help obj = helpService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/key", method=RequestMethod.GET)
	public ResponseEntity<Help> findByKey(@RequestParam(name = "keyValue") String keyValue) {
		
		Help obj = helpService.findByKey(keyValue);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Help>> findAll() {
		
		List<Help> list = helpService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Help help) {
				
		help = helpService.create(help);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(help.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Help help, @PathVariable Long id) {
		
		help.setId(id);
		help = helpService.update(help);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		helpService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}

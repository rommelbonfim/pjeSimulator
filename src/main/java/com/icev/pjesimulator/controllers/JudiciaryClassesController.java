package com.icev.pjesimulator.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.icev.pjesimulator.dto.JudiciaryClassesDto;
import com.icev.pjesimulator.form.JudiciaryClassesForm;
import com.icev.pjesimulator.models.JudiciaryClasses;
import com.icev.pjesimulator.services.JudiciaryClassesService;

@RestController
@RequestMapping(value = "/classe_judicial")
public class JudiciaryClassesController {

    @Autowired
    private JudiciaryClassesService service;

    @PostMapping
    public ResponseEntity<JudiciaryClassesDto> insert(@RequestBody JudiciaryClassesForm form) {
        JudiciaryClassesDto dto = service.insert(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<JudiciaryClasses>> findAll() {
        List<JudiciaryClasses> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JudiciaryClassesDto> findById(@PathVariable Long id) {
        JudiciaryClassesDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    
    @GetMapping(value = "/matter/{id}")
    public ResponseEntity<List<JudiciaryClassesDto>> findByMatterId(@PathVariable Long id) {
        List<JudiciaryClassesDto> dto = service.findByMatterId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<JudiciaryClassesDto> update(@PathVariable Long id, @RequestBody JudiciaryClassesForm form) {
        JudiciaryClassesDto dto = service.update(id, form);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

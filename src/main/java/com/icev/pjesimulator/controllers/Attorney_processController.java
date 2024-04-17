package com.icev.pjesimulator.controllers;


import com.icev.pjesimulator.dto.Attorney_ProcessDto;
import com.icev.pjesimulator.form.Attorney_ProcessForm;
import com.icev.pjesimulator.models.AuxilarClassAttorneyProcess;
import com.icev.pjesimulator.services.Attorney_ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/attorney_process")
public class Attorney_processController {

    @Autowired
    private Attorney_ProcessService service;

    @PostMapping
    public ResponseEntity<Attorney_ProcessDto> insert(@RequestBody Attorney_ProcessForm form) {
        Attorney_ProcessDto dto = service.insert(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(form).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    
    @GetMapping
    public ResponseEntity<List<Attorney_ProcessDto>> findAll() {
        List<AuxilarClassAttorneyProcess> list = service.findAll();
        List<Attorney_ProcessDto> listDto = list.stream().map(service::fromAttorney_Process).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Attorney_ProcessDto> findById(@PathVariable Long id) {
        Attorney_ProcessDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    

    @PutMapping(value = "/{id}")
    public ResponseEntity<Attorney_ProcessDto> update(@PathVariable Long id, @RequestBody Attorney_ProcessForm form) {
        Attorney_ProcessDto dto = service.update(id, form);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

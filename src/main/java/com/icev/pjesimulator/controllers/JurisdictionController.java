package com.icev.pjesimulator.controllers;



import com.icev.pjesimulator.dto.JurisdictionDto;
import com.icev.pjesimulator.form.JurisdictionForm;
import com.icev.pjesimulator.models.Jurisdiction;
import com.icev.pjesimulator.services.JurisdictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/jurisdicao")
public class JurisdictionController {

    @Autowired
    private JurisdictionService service;

    @PostMapping
    public ResponseEntity<JurisdictionDto> insert(@RequestBody JurisdictionForm form) {
        JurisdictionDto dto = service.insert(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(form.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<JurisdictionDto>> findAll() {
        List<Jurisdiction> list = service.findAll();
        List<JurisdictionDto> listDto = list.stream().map(service::fromJurisdiction).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JurisdictionDto> findById(@PathVariable Long id) {
        JurisdictionDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    
    @GetMapping(value = "matter/{id}")
    public ResponseEntity<List<JurisdictionDto>> findByMatterId(@PathVariable Long id) {
        List<JurisdictionDto> list = service.findByMatterId(id);
        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<JurisdictionDto> update(@PathVariable Long id, @RequestBody JurisdictionForm form) {
        JurisdictionDto dto = service.update(id, form);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

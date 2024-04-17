package com.icev.pjesimulator.controllers;


import com.icev.pjesimulator.dto.MatterDto;
import com.icev.pjesimulator.form.MatterForm;
import com.icev.pjesimulator.models.Matter;
import com.icev.pjesimulator.services.MatterService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/materias")
public class MatterController {

    private final MatterService service;

    public MatterController(MatterService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MatterDto> insert(@RequestBody MatterForm form) {
        MatterDto dto = service.insert(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<MatterDto>> findAll() {
        List<Matter> list = service.findAll();
        List<MatterDto> listDto = list.stream().map(service::fromMatter).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MatterDto> findById(@PathVariable Long id) {
        MatterDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MatterDto> update(@PathVariable Long id, @RequestBody MatterForm form) {
        MatterDto dto = service.update(id, form);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

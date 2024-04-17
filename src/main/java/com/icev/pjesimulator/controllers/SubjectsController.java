package com.icev.pjesimulator.controllers;


import com.icev.pjesimulator.dto.SubjectsDto;
import com.icev.pjesimulator.form.SubjectsForm;
import com.icev.pjesimulator.models.Subjects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import com.icev.pjesimulator.services.SubjectsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/subject")
public class SubjectsController {

    private final SubjectsService service;

    public SubjectsController(SubjectsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SubjectsDto> insert(@RequestBody SubjectsForm form) {
        SubjectsDto dto = service.insert(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<SubjectsDto>> findAll(@PageableDefault(page = 0, size = 10) Pageable pagination) {
        Page<Subjects> list = service.findAll(pagination);
        Page<SubjectsDto> listDto = list.map(service::fromSubjects);
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SubjectsDto> findById(@PathVariable Long id) {
        SubjectsDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SubjectsDto> update(@PathVariable Long id, @RequestBody SubjectsForm form) {
        SubjectsDto dto = service.update(id, form);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

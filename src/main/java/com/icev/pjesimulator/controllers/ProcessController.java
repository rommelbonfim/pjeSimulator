package com.icev.pjesimulator.controllers;

import com.icev.pjesimulator.dto.ProcessDto;
import com.icev.pjesimulator.form.ProcessForm;
import com.icev.pjesimulator.models.Process;
import com.icev.pjesimulator.services.ProcessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/process")
public class ProcessController {
    private final ProcessService service;

    public ProcessController(ProcessService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProcessDto> insert(@RequestBody ProcessForm form) {
        ProcessDto dto = service.insert(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProcessDto>> findAll() {
        List<Process> list = service.findAll();
        List<ProcessDto> listDto = list.stream().map(service::fromProcess).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Process> findById(@PathVariable Long id) {
//        ProcessDto dto = service.findById(id);
        Process dto = service.findById(id);

        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProcessDto> update(@PathVariable Long id, @RequestBody ProcessForm form) {
        ProcessDto dto = service.update(id, form);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

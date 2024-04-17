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

import com.icev.pjesimulator.dto.CompetenceDto;
import com.icev.pjesimulator.form.CompetenceForm;
import com.icev.pjesimulator.models.Competence;
import com.icev.pjesimulator.services.CompetenceService;

@RestController
@RequestMapping(value = "/competence")
public class CompetenceController {

    @Autowired
    private CompetenceService service;

    @PostMapping
    public ResponseEntity<CompetenceDto> insert(@RequestBody CompetenceForm form) {
        CompetenceDto dto = service.insert(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(form).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    
    @GetMapping
    public ResponseEntity<List<CompetenceDto>> findAll() {
        List<Competence> list = service.findAll();
        List<CompetenceDto> listDto = list.stream().map(service::fromCompetence).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompetenceDto> findById(@PathVariable Long id) {
        CompetenceDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    

    @PutMapping(value = "/{id}")
    public ResponseEntity<CompetenceDto> update(@PathVariable Long id, @RequestBody CompetenceForm form) {
        CompetenceDto dto = service.update(id, form);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findone")
    public ResponseEntity<CompetenceDto> getCompetenceByJurisdictionJudiciary(@RequestBody CompetenceForm form) {
        CompetenceDto dto = service.findByJuridictionJudiciaryClass(form.getJurisdictionId(), form.getJudiciaryClassId());
        return ResponseEntity.ok().body(dto);
    }
}

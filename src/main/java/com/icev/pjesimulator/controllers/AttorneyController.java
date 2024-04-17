package com.icev.pjesimulator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icev.pjesimulator.dto.AttorneyDto;
import com.icev.pjesimulator.form.AttorneyForm;
import com.icev.pjesimulator.models.Attorney;
import com.icev.pjesimulator.services.AttorneyService;

@RestController
@RequestMapping(value = "/attorney")
public class AttorneyController {

    @Autowired
    private AttorneyService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<AttorneyDto> findById(@PathVariable Long id) {

        AttorneyDto obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Attorney>> findAll() {

        List<Attorney> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<AttorneyDto> insert(@RequestBody AttorneyForm form) {

        AttorneyDto attorneyDto = service.insert(form);

        return ResponseEntity.ok().body(attorneyDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<AttorneyDto> update(@RequestBody AttorneyForm form, @PathVariable Long id) {


        AttorneyDto attorneyDto = service.update(id, form);

        return ResponseEntity.ok().body(attorneyDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}

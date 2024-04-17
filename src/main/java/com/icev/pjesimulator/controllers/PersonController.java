package com.icev.pjesimulator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icev.pjesimulator.dto.PersonDto;
import com.icev.pjesimulator.form.PersonForm;
import com.icev.pjesimulator.models.Person;
import com.icev.pjesimulator.services.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<PersonDto> findById(@PathVariable Long id) {

        PersonDto obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Person>> findAll() {

        List<Person> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<PersonDto> insert(@RequestBody PersonForm form) {

        PersonDto personDto = service.insert(form);

        return ResponseEntity.ok().body(personDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<PersonDto> update(@RequestBody PersonForm form, @PathVariable Long id) {


        PersonDto personDto = service.update(id, form);

        return ResponseEntity.ok().body(personDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}

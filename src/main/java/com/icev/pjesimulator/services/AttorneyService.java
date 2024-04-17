package com.icev.pjesimulator.services;

import com.icev.pjesimulator.dto.AttorneyDto;
import com.icev.pjesimulator.dto.CompetenceDto;
import com.icev.pjesimulator.dto.ProcessDto;
import com.icev.pjesimulator.enums.AttorneyType;
import com.icev.pjesimulator.enums.PersonType;
import com.icev.pjesimulator.form.AttorneyForm;
import com.icev.pjesimulator.form.CompetenceForm;
import com.icev.pjesimulator.form.ProcessForm;
import com.icev.pjesimulator.models.*;
import com.icev.pjesimulator.models.Process;
import com.icev.pjesimulator.repositories.*;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.EntityNotFoundException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class AttorneyService {




    @Autowired
    PersonRepository personRepo;

    @Autowired
    AttorneyRepository attorneyRepo;

    public AttorneyDto insert(AttorneyForm form) {
        Attorney attorney = new Attorney();
        attorney.setPerson( personRepo.findById(form.getPersonId()).get());
        attorney.setType(AttorneyType.getTypeByName(form.getType()));
        attorneyRepo.save(attorney);
        return new AttorneyDto(attorney);
    }

    public List<Attorney> findAll() {
        return attorneyRepo.findAll();
    }

    public AttorneyDto findById(Long id) {
        Optional<Attorney> obj = attorneyRepo.findById(id);
        Attorney attorney = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new AttorneyDto(attorney);
    }

    @Transactional
    public AttorneyDto update(Long id, AttorneyForm form) {
        Attorney attorney = attorneyRepo.findById(id).get();
        attorney.setPerson( personRepo.findById(form.getPersonId()).get());
        attorney.setType(AttorneyType.getTypeByName(form.getType()));
        attorneyRepo.save(attorney);
        return new AttorneyDto(attorney.getId());

    }

    public void delete(Long id) {
        try {
            findById(id);
            attorneyRepo.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id not found to delete");
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("Empty search result");
        }
    }

    public AttorneyDto fromAttorney(Attorney entity) {
        return new AttorneyDto(entity.getId());
    }
}

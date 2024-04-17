package com.icev.pjesimulator.services;

import com.icev.pjesimulator.dto.Attorney_ProcessDto;
import com.icev.pjesimulator.form.Attorney_ProcessForm;
import com.icev.pjesimulator.models.AuxilarClassAttorneyProcess;
import com.icev.pjesimulator.repositories.*;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class Attorney_ProcessService {
    @Autowired
    AttorneyRepository attorneyRepo;

    @Autowired
    ProcessRepository processRepo;

    @Autowired
    Attorney_ProcessRepository attorney_processRepositoryRepo;

    public Attorney_ProcessDto insert(Attorney_ProcessForm form) {
        AuxilarClassAttorneyProcess auxilarClassAttorney_process = new AuxilarClassAttorneyProcess();

        auxilarClassAttorney_process.setAttorney(attorneyRepo.findById(form.getAttorneyId()).get());
        auxilarClassAttorney_process.setProcess(processRepo.findById(form.getProcessId()).get());
        attorney_processRepositoryRepo.save(auxilarClassAttorney_process);
        return new Attorney_ProcessDto(auxilarClassAttorney_process.getId());
    }

    public List<AuxilarClassAttorneyProcess> findAll() {
        return attorney_processRepositoryRepo.findAll();
    }

    public Attorney_ProcessDto findById(Long id) {
        Optional<AuxilarClassAttorneyProcess> obj = attorney_processRepositoryRepo.findById(id);
        AuxilarClassAttorneyProcess auxilarClassAttorney_process = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new Attorney_ProcessDto(auxilarClassAttorney_process.getId());
    }

    @Transactional
    public Attorney_ProcessDto update(Long id, Attorney_ProcessForm form) {
        AuxilarClassAttorneyProcess auxilarClassAttorney_process = attorney_processRepositoryRepo.findById(id).get();
        auxilarClassAttorney_process.setAttorney(attorneyRepo.findById(form.getAttorneyId()).get());
        auxilarClassAttorney_process.setProcess(processRepo.findById(form.getProcessId()).get());
        attorney_processRepositoryRepo.save(auxilarClassAttorney_process);
        return new Attorney_ProcessDto(auxilarClassAttorney_process.getId());

    }

    public void delete(Long id) {
        try {
            findById(id);
            attorney_processRepositoryRepo.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id not found to delete");
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("Empty search result");
        }
    }

    public Attorney_ProcessDto fromAttorney_Process(AuxilarClassAttorneyProcess entity) {
        return new Attorney_ProcessDto(entity.getId());
    }
}

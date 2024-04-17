package com.icev.pjesimulator.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icev.pjesimulator.dto.JudiciaryClassesDto;
import com.icev.pjesimulator.form.JudiciaryClassesForm;
import com.icev.pjesimulator.models.JudiciaryClasses;
import com.icev.pjesimulator.models.Matter;
import com.icev.pjesimulator.repositories.JudiciaryClassesRepository;
import com.icev.pjesimulator.repositories.JurisdictionRepository;
import com.icev.pjesimulator.repositories.MatterRepository;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;

@Service
public class JudiciaryClassesService {

    @Autowired
    private JudiciaryClassesRepository repository;

    @Autowired
    private MatterRepository matterRepository;

    @Transactional
    public JudiciaryClassesDto insert(JudiciaryClassesForm form) {
        JudiciaryClasses judClass = new JudiciaryClasses();
        judClass.setDescription(form.getDescription());
        Matter matter = matterRepository.findById(form.getMatter_id()).get();
        matter.getJudiciaryClasses().add(judClass);
        judClass.setMatter(matter);
        judClass = repository.save(judClass);
        return new JudiciaryClassesDto(judClass);
    }

    public JudiciaryClassesDto findById(Long id) {
        Optional<JudiciaryClasses> obj = repository.findById(id);
        JudiciaryClasses judClass = obj.orElseThrow(() -> new ResourceNotFoundException("judClass not found"));
        return new JudiciaryClassesDto(judClass);
    }

    public List<JudiciaryClasses> findAll() {
        return repository.findAll();
    }

    @Transactional
    public JudiciaryClassesDto update(Long id, JudiciaryClassesForm form) {
        try {
            JudiciaryClasses judClass = repository.getById(id);
            if (form.getDescription() != null) {
                judClass.setDescription(form.getDescription());
            }
            if (form.getMatter_id() != null) {
                Matter matter = matterRepository.findById(form.getMatter_id()).get();
                judClass.setMatter(matter);
            }
            judClass = repository.save(judClass);
            return new JudiciaryClassesDto(judClass);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id not found to delete");
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("Empty search result");
        }
    }

    public void delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id not found to delete");
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("Empty search result");
        }
    }

    public List<JudiciaryClassesDto> findByMatterId(Long id) {
        List<JudiciaryClasses> list = repository.findByMatterId(id);
        return list.stream().map(this::fromJudiciaryClasses)
                .collect(Collectors.toList());
    }

    public JudiciaryClassesDto fromJudiciaryClasses(JudiciaryClasses judiciaryClasses) {
        return new JudiciaryClassesDto(judiciaryClasses.getId(), judiciaryClasses.getDescription());
    }
}

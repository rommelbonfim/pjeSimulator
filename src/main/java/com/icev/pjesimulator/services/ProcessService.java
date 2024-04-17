package com.icev.pjesimulator.services;

import static com.icev.pjesimulator.utils.Utils.GenerateNumProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icev.pjesimulator.dto.ProcessDto;
import com.icev.pjesimulator.form.ProcessForm;
import com.icev.pjesimulator.models.AuxiliarClassProcessSubject;
import com.icev.pjesimulator.models.Process;
import com.icev.pjesimulator.models.Subjects;
import com.icev.pjesimulator.repositories.AuxiliarClassProcessSubjectRepository;
import com.icev.pjesimulator.repositories.CompetenceRepository;
import com.icev.pjesimulator.repositories.ProcessRepository;
import com.icev.pjesimulator.repositories.SubjectsRepository;
import com.icev.pjesimulator.services.exceptions.EmptyResultDataAccessException;
import com.icev.pjesimulator.services.exceptions.EntityNotFoundException;
import com.icev.pjesimulator.services.exceptions.ResourceNotFoundException;

@Service
public class ProcessService {

	@Autowired
	private ProcessRepository repository;
	@Autowired
	private CompetenceRepository competencyRepo;
	@Autowired
	private SubjectsRepository subjectsRepository;
	@Autowired
	private AuxiliarClassProcessSubjectRepository auxiliarRepository;

	@Transactional
	public ProcessDto insert(ProcessForm form) {
		Process entity = new Process();
		entity.setNumProcess(GenerateNumProcess());
		entity.setCompetence(competencyRepo.findById(form.getCompetence()).get());
		entity = repository.save(entity);
		AuxiliarClassProcessSubject auxiliarProcessSubject = new AuxiliarClassProcessSubject();
		List<Subjects> subjects = new ArrayList<>();
		for(Long id : form.getSubjects()) {
			Subjects subject = subjectsRepository.findById(id).get();
			subjects.add(subject);
			auxiliarProcessSubject.setProcess(entity);
			auxiliarProcessSubject.setSubject(subject);
			auxiliarRepository.save(auxiliarProcessSubject);
		}
		entity = repository.save(entity);
		return new ProcessDto(entity);
	}

	public Process findById(Long id) {
		Optional<Process> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
	}

	public List<Process> findAll() {
		return repository.findAll();
	}

	@Transactional
	public ProcessDto update(Long id, ProcessForm form) {
        try {
            Process entity = repository.getById(id);
            if (form.getCompetence() != null) {
                entity.setCompetence(competencyRepo.findById(form.getCompetence()).get());
            }
            entity = repository.save(entity);
            return new ProcessDto(entity);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id not found to delete");
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("Empty search result");
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Empty search result");
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

	public ProcessDto fromProcess(Process process) {
		return new ProcessDto(process);
	}

}

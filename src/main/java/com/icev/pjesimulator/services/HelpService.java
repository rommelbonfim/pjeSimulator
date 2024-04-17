package com.icev.pjesimulator.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icev.pjesimulator.models.Help;
import com.icev.pjesimulator.repositories.HelpRepository;

@Service
public class HelpService {
	
	@Autowired
	private HelpRepository helpRepository;
	
	public Help create(Help help) {
		help.setId(null);
		return helpRepository.save(help);
	}
	
	public List<Help> findAll() {
		return helpRepository.findAll();
	}
	
	public Help findById(Long id) {
		Optional<Help> obj = helpRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Help não encontrado!" + " Tipo: " + Help.class.getName(), null));
	}
	
	public Help findByKey(String key) {
		Optional<Help> obj = helpRepository.findByKey(key);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Help não encontrado!" + " Tipo: " + Help.class.getName(), null));
	}
	
	public Help update(Help obj) {
		Help newObj = findById(obj.getId());
		updateData(newObj, obj);
		return helpRepository.save(newObj);
	}
	
	private void updateData(Help newObj, Help obj) {
		newObj.setKey(obj.getKey());
		newObj.setDescription(obj.getDescription());
	}
	
	public void delete(Long id) {
		try {
			helpRepository.deleteById(id);
		}
		catch(ObjectNotFoundException e) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado!" + " Tipo: " + Help.class.getName(), null);
		}
	}
}

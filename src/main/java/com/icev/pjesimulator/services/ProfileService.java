package com.icev.pjesimulator.services;

import com.icev.pjesimulator.dto.ProfileDto;
import com.icev.pjesimulator.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.icev.pjesimulator.repositories.ProfileRepository;

import javax.transaction.Transactional;

@Service
public class ProfileService {

    private BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

    @Autowired
    private ProfileRepository repository;


    @Transactional
    public ProfileDto insert(ProfileDto dto){
        Profile entity = new Profile();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPeriod(dto.getPeriod());
        entity.setRegistrationNumber(dto.getRegistrationNumber());
        entity.setCpf(dto.getCpf());
        entity.setPassword(pe.encode(dto.getPassword()));
        entity = repository.save(entity);
        return new ProfileDto(entity);
    }

}

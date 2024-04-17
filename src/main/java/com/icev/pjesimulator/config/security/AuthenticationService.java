package com.icev.pjesimulator.config.security;

import java.util.Optional;

import com.icev.pjesimulator.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.icev.pjesimulator.repositories.ProfileRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Profile> user = profileRepository.findByCpf(username);
		if (user.isPresent()) {
			return user.get();
		}
		throw new UsernameNotFoundException("Dados inválidos");
	}
}

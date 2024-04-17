package com.icev.pjesimulator.controllers;


import com.icev.pjesimulator.config.security.TokenService;
import com.icev.pjesimulator.dto.TokenDto;
import com.icev.pjesimulator.form.LoginForm;
import com.icev.pjesimulator.models.Profile;
import com.icev.pjesimulator.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm login) {
        UsernamePasswordAuthenticationToken dadosLogin = login.converter();

        //Retorna o nome do usuário no token
        Optional<Profile> user = profileRepository.findByCpf(login.getCpf());
        String nameUsuario = null;
        if (user.isPresent()) {
            nameUsuario = user.get().getName();
        }
        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.createToken(authentication);
            return ResponseEntity.ok(new TokenDto("Bearer ", token, nameUsuario));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

package com.icev.pjesimulator.config.security;

import com.icev.pjesimulator.models.Profile;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${pje-simulator.jwt.expiration}")
    private String expiration;

    @Value("${pje-simulator.jwt.secret}")
    private String secret;

    public String createToken(Authentication authentication) {
        Profile logado = (Profile) authentication.getPrincipal();
        Date today = new Date();
        Date dataExpiration = new Date(today.getTime() + Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("API do PJE Simulator")
                .setSubject(logado.getId().toString())
                .setIssuedAt(today)
                .setExpiration(dataExpiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}

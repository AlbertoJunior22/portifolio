package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.UserDetailsDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${application.jwt.expiration.time}")
    private Long tokenExpiration;

    @Value("${application.jwt.secret.word}")
    private String secretPass;

    public String generateToken(Authentication authentication) {
        UserDetailsDTO user = (UserDetailsDTO) authentication.getPrincipal();
        Date expiration = new Date(new Date().getTime() + tokenExpiration);

        String token = Jwts.builder()
                .setIssuer("e-commerce")
                .setSubject(user.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secretPass).compact();

        return token;
    }

    public boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(secretPass)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getTokenId(String token) {
        String id = Jwts.parser().setSigningKey(secretPass)
                .parseClaimsJws(token).getBody().getSubject();
        return Integer.parseInt(id);
    }
}

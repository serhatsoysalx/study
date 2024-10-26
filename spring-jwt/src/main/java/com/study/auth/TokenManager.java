package com.study.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenManager {

    @Value("${jwt.expiration}")
    private long expirationTime;

    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    public boolean validateToken(String token, String username) {
        final String extractedUsername = getUserFromToken(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public String getUserFromToken(String token) {
        return getClaims(token).getSubject();
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration()
                .before(new Date(System.currentTimeMillis()));
    }

    private String createToken(Map<String, Object> claims, String subject) {
        Date nowDate = new Date(System.currentTimeMillis());
        Date expiredDate = new Date(nowDate.getTime() + expirationTime);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(nowDate)
                .setExpiration(expiredDate)
                .signWith(secretKey) // Güncellenmiş anahtar kullanılıyor
                .compact();
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey) // Güncellenmiş anahtar kullanılıyor
                .parseClaimsJws(token)
                .getBody();
    }
}

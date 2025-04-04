package com.middleware.global_admin.Service.JWT;

import com.middleware.global_admin.Entity.Admin;
import com.middleware.global_admin.Repository.AdminRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.Function;

@Service
public class JWTService {

    private final AdminRepository adminRepository;

    private String secretKey = "";

    public JWTService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey key = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(key.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public String generateToken(String email) {
        Optional<Admin> admin = adminRepository.findByEmail(email);
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", admin.get().getEmail());
        return Jwts.builder()
                .claims(claims)
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .signWith(getKey())
                .compact();
    }

    private SecretKey getKey() {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    private <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String jwtToken) {
        return Jwts.parser()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    public boolean validateToken(String jwtToken, UserDetails userDetails) {
        return extractUsername(jwtToken).equals(userDetails.getUsername()) && !isTokenExpired(jwtToken);
    }

    private boolean isTokenExpired(String jwtToken) {
        return extractClaim(jwtToken, Claims::getExpiration).before(new Date());
    }

}

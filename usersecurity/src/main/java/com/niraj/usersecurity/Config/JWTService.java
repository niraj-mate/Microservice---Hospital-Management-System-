
package com.niraj.usersecurity.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    private final SecretKey key = generateSecretKey();

    private SecretKey secretKey() {
        return key;
    }

    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims(claims)
                .subject(userName)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000L * 60 * 3))
                .signWith(secretKey())
                .compact();
    }

    public SecretKey generateSecretKey() {
        return Jwts.SIG.HS256.key().build();
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(
            String token,
            Function<Claims, T> claimResolver) {

        Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String userName = extractUserName(token);

        return userName.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
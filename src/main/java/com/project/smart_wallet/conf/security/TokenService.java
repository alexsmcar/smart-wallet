package com.project.smart_wallet.conf.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.project.smart_wallet.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withIssuer("smart-wallet")
                .withSubject(user.getEmail())
                .withIssuedAt(Instant.now())
                .withExpiresAt(getExpirationTime())
                .sign(algorithm);
    }

    public String validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm)
                .withIssuer("smart-wallet")
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant getExpirationTime() {
        return Instant.now().plus(Duration.ofHours(2));
    }

}

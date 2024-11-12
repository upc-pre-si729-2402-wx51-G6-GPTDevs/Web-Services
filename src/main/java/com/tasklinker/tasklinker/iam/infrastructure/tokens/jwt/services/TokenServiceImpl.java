package com.tasklinker.tasklinker.iam.infrastructure.tokens.jwt.services;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tasklinker.tasklinker.iam.application.internal.outboundservices.tokens.jwt.TokenService;

@Service
public class TokenServiceImpl implements TokenService {
    @Value("${authorization.jwt.secret}")
    private String secret;

    @Value("${authorization.jwt.expiration.days}")
    private int expirationDays;

    @Override
    public String generateToke(Long id, String name, String email) {
        var algorithm = Algorithm.HMAC256(secret);

        var issuedAt = new Date();
        var expiration = DateUtils.addDays(issuedAt, expirationDays);

        return JWT.create()
                .withClaim("id", id)
                .withClaim("name", name)
                .withClaim("email", email)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiration)
                .sign(algorithm);
    }
}

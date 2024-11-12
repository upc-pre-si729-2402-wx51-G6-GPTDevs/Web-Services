package com.tasklinker.tasklinker.iam.application.internal.outboundservices.tokens.jwt;

public interface TokenService {
    // TODO documentation
    /**
     * Generate a token for a given email
     * 
     * @param email the email
     * @return String the token
     */
    String generateToke(Long id, String name, String email);
}

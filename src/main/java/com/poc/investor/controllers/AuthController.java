package com.poc.investor.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);


    private final JwtEncoder jwtEncoder;

    public AuthController(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    /**
     * Generate JWT from jwtEncoder by the set of jwtClaims
     * <p>
     * <p>
     * curl --location --request POST 'http://localhost:1717/token' \
     * --header 'Authorization: Basic ##user:password in base64 ##'
     * for examle smail:1234 is c21haWw6MTIzNA== with base64
     * <p>
     * curl --location 'http://localhost:1717/investors' \
     * --header 'Authorization: Bearer ##token generated by AuthController.token##'
     *
     * @param authentication Retrieve information of users already logged in.
     * @return
     */
    @PostMapping("/token")
    public Map<String, String> requestForToken(Authentication authentication) {
        Instant instant = Instant.now();
        String scopes = authentication.getAuthorities().stream().map(grantedAuthority -> grantedAuthority.getAuthority()).collect(Collectors.joining(" "));
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder().subject(authentication.getName())//userName already logged in
                .issuedAt(instant)//created datetime
                .expiresAt(instant.plus(5, ChronoUnit.MINUTES)).issuer("investor")//name of application that generate token
                .claim("scope", scopes)//Authorities of users logged in
                .build();
        Map<String, String> idToken = new HashMap<>();
        //generate JWT from jwtEncoder by the set of jwtClaims
        idToken.put("accessToken", jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue());
        return idToken;
    }


}
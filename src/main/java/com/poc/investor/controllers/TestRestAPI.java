package com.poc.investor.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestRestAPI {
    /**
     * link for test
     * curl --location 'http://localhost:1717/dataTest' \
     * --header 'Authorization: Bearer ##token##'
     * @param authentication
     * @return
     */
    @GetMapping("/dataTest")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Map<String, Object> dataTest(Authentication authentication){
        return Map.of(
                "message","Data test",
                "username",authentication.getName(),
                "authorities",authentication.getAuthorities()
        );
    }

    /**+
     * link for test :
     * curl --location 'http://localhost:1717/saveData?data=sss' \
     * --header 'Authorization: Bearer ##token'
     * @param data
     * @return
     */
    @GetMapping("/saveData")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Map<String,String> saveData(String data){
        return Map.of("dataSaved",data);
    }
}
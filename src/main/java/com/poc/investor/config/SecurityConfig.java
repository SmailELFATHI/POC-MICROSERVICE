package com.poc.investor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                //	.headers().frameOptions().disable().and()
                //.authorizeRequests(auth -> auth.antMatchers("/h2-console/**").permitAll() )
                //.authorizeRequests(auth -> auth.antMatchers("/idToken/**","/token/**").permitAll() )
                //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .authorizeRequests(auth -> auth.anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .build();
    }


    @Bean
    InMemoryUserDetailsManager InMemoryUserDetailsManager() {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager(User.withUsername("smail").password("{noop}1234").authorities("read").build());
        return userDetailsService;
    }
}
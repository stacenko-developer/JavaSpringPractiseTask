package com.i_sys.practise.web.configures;

import com.i_sys.practise.core.domains.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                // disable CSRF as we do not serve browser clients
//                .csrf().disable()
//                // allow access restriction using request matcher
//                .authorizeRequests()
//                // authenticate requests to GraphQL endpoint
//                .antMatchers("/graphql").authenticated()
//                // allow all other requests
//                .anyRequest().permitAll().and()
//                // JWT authorization filter
//                .apply(new JWTHttpConfigurer(jwtTokenUtils)).and()
//                // make sure we use stateless session, session will not be used to store user's state
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        return http.build();
//    }
//
//}
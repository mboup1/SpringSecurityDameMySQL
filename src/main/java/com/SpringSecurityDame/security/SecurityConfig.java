package com.SpringSecurityDame.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    MyUserDetailsService userDetailsService;

//    @Autowired
//    AuthenticationManager authMgr;
// Injectez ou créez une instance de votre JWTAuthenticationFilter
//    @Autowired
//    JWTAuthenticationFilter jwtAuthenticationFilter;
//
//    public SecurityConfig(JWTAuthenticationFilter jwtAuthenticationFilter) {
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/users/all").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/users/public").permitAll()
                        .requestMatchers("/users/protected").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/users/user").hasRole("USER")
                        .requestMatchers("/users/admin").hasRole("ADMIN")
                        .requestMatchers("/users/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated()
//                        .and().addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

                )
                .userDetailsService(userDetailsService)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}

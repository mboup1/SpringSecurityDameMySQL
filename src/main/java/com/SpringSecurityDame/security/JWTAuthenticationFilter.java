//package com.SpringSecurityDame.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private AuthenticationManager authenticationManager;
//
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//        super();
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        // Extract credentials and perform authentication
//        return super.attemptAuthentication(request, response);
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
//                                            Authentication authResult) throws IOException {
//
//        User springUser = (User) authResult.getPrincipal();
//
//        List<String> roles = new ArrayList<>();
//        springUser.getAuthorities().forEach(au-> {
//            roles.add(au.getAuthority());
//        });
//
//        String token = JWT.create()
//                .withSubject(springUser.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + SecParams.EXP_TIME))
//                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
//                .sign(Algorithm.HMAC256(SecParams.SECRET));
//
//        response.addHeader("Authorization", "Bearer " + token);
//    }
//}

package com.ksga.springminiproject002.controller.rest;

import com.ksga.springminiproject002.payload.request.LoginRequest;
import com.ksga.springminiproject002.payload.response.LoginResponse;
import com.ksga.springminiproject002.repository.UserRepository;
import com.ksga.springminiproject002.security.jwt.JwtUtils;
import com.ksga.springminiproject002.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthRestController {

    AuthenticationManager authenticationManager;
    JwtUtils jwtUtils;
    UserRepository userRepository;
    PasswordEncoder encoder;
    @Autowired
    public AuthRestController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Set<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
        return new ResponseEntity<>(new LoginResponse(userDetails.getId(),jwt,userDetails.getUsername()), HttpStatus.OK);
//        return Response.<JwtResponse>ok().setPayload(
//                new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername())
//        );
    }
}

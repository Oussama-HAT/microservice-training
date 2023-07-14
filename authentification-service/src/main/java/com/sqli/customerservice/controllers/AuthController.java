package com.sqli.customerservice.controllers;

import com.sqli.customerservice.dto.JwtResponse;
import com.sqli.customerservice.dto.LoginRequest;
import com.sqli.customerservice.entities.Account;
import com.sqli.customerservice.security.JwtUtils;
import com.sqli.customerservice.services.Impl.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtils jwtUtils;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager,
                          UserDetailsServiceImpl userDetailsService,
                          JwtUtils jwtUtils,
                          BCryptPasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            // Invalid credentials
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String token = jwtUtils.generateToken((Account) userDetails);


        return ResponseEntity.ok(new JwtResponse(token));
    }

//    @PostMapping("/api/auth/register")
//    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
//        // Create a new account with the provided details
//        Account account = new Account();
//        account.setUsername(registerRequest.getUsername());
//        account.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
//        // Save the account to your repository
//
//        return ResponseEntity.ok().build();
//    }
}


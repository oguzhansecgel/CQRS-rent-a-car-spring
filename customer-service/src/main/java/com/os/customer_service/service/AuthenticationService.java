package com.os.customer_service.service;

import com.os.customer_service.dto.AuthenticationRequest;
import com.os.customer_service.dto.LoginResponse;
import com.os.customer_service.dto.RegisterResponse;
import com.os.customer_service.dto.RegisterRequest;
import com.os.customer_service.config.JwtService;
import com.os.customer_service.repository.UserRepository;
import com.os.customer_service.user.Role;
import com.os.customer_service.user.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager  authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public RegisterResponse register(RegisterRequest request) {
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        User savedUser =  userRepository.save(user);
        return new RegisterResponse(savedUser.getFirstname(),savedUser.getLastname(), savedUser.getEmail(), savedUser.getPassword());

    }

    public LoginResponse authenticate(AuthenticationRequest request) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            User user = userRepository.findByEmail(request.getEmail()).orElse(null);
            String jwtToken = jwtService.generateToken(user);
            return new LoginResponse(jwtToken, user.getId());

    }
}
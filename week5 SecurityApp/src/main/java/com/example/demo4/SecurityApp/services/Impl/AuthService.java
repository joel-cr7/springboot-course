package com.example.demo4.SecurityApp.services.Impl;


import com.example.demo4.SecurityApp.dto.LoginDTO;
import com.example.demo4.SecurityApp.entities.User;
import com.example.demo4.SecurityApp.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;         // create bean in config
    private final JWTService jwtService;

    public String login(LoginDTO loginDTO) {
        // Authenticate the user
        Authentication auth = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(auth);

        // get authenticated user
        User user = (User) authentication.getPrincipal();

        // get JWT token
        return jwtService.generateToken(user);
    }
}

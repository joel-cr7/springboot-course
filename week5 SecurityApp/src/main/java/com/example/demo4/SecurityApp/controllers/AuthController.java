package com.example.demo4.SecurityApp.controllers;


import com.example.demo4.SecurityApp.dto.LoginDTO;
import com.example.demo4.SecurityApp.dto.LoginResponseDTO;
import com.example.demo4.SecurityApp.dto.SignUpDTO;
import com.example.demo4.SecurityApp.dto.UserDTO;
import com.example.demo4.SecurityApp.services.Impl.AuthService;
import com.example.demo4.SecurityApp.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO signUpDTO){
        UserDTO userDTO = userService.signUp(signUpDTO);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO, HttpServletResponse response){
        LoginResponseDTO loginResponseDTO = authService.login(loginDTO);

        Cookie cookie = new Cookie("refreshToken", loginResponseDTO.getRefreshToken());
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return ResponseEntity.ok(loginResponseDTO);
    }


    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDTO> refresh(HttpServletRequest request){
        Cookie cookies[] = request.getCookies();

        String refreshToken = Arrays.stream(cookies)
                .filter(cookie -> "refreshToken".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(() -> new AuthenticationServiceException("Refresh token not found inside cookies !!"));

        LoginResponseDTO loginResponseDTO = authService.refreshToken(refreshToken);

        return ResponseEntity.ok(loginResponseDTO);
    }

}

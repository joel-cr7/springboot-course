package com.example.demo4.SecurityApp.services;


import com.example.demo4.SecurityApp.dto.LoginDTO;
import com.example.demo4.SecurityApp.dto.SignUpDTO;
import com.example.demo4.SecurityApp.dto.UserDTO;
import com.example.demo4.SecurityApp.entities.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User findUserById(Long userId);
    UserDTO signUp(SignUpDTO signUpDTO);
}

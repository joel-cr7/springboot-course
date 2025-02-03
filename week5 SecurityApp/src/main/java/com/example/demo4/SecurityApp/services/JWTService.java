package com.example.demo4.SecurityApp.services;

import com.example.demo4.SecurityApp.entities.User;

public interface JWTService {
    // Here we just require 2 methods
    // 1) Create token
    // 2) Verify token and return user id

    // takes our current user as input to generate token
    String generateAccessToken(User user);

    String generateRefreshToken(User user);

    Long getUserIdFromToken(String token);
}

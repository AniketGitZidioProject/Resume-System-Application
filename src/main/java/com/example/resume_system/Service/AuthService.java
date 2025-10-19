package com.example.resume_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.resume_system.DTO.AuthResponse;
import com.example.resume_system.DTO.LoginRequest;
import com.example.resume_system.DTO.RegisterRequest;
import com.example.resume_system.Entity.User;
import com.example.resume_system.Repository.UserRepository;
import com.example.resume_system.Security.JWTUtil;

import jakarta.transaction.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        // 1️⃣ Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // 2️⃣ Create new user and encode password
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // 3️⃣ Save user
        User savedUser = userRepository.save(user);

        // 4️⃣ Generate JWT token
        String token;
        try {
            token = jwtUtil.generateToken(savedUser.getEmail());
        } catch (Exception e) {
            // 🔴 Rollback DB insert if JWT fails
            throw new RuntimeException("Failed to generate JWT token", e);
        }

        // 5️⃣ Return response
        return new AuthResponse(savedUser.getId(), savedUser.getEmail(), token);
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        // ✅ Compare password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // ✅ Generate token
        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(user.getId(), user.getEmail(), token);
    }
}

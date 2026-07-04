package com.cognizant.jwtauth.controller;

import com.cognizant.jwtauth.model.JwtResponse;
import com.cognizant.jwtauth.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    public AuthenticationController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<JwtResponse> authenticate(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Basic ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String base64Credentials = authorization.substring("Basic ".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);
        String[] values = credentials.split(":", 2);
        if (values.length != 2) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String username = values[0];
        String password = values[1];
        if (!"user".equals(username) || !"pwd".equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = jwtService.generateToken(username);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}

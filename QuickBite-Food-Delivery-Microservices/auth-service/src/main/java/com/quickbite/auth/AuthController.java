package com.quickbite.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final String SECRET =
            "QuickBiteDemoSecretKeyForJWTAuthentication1234567890";

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (!"divya".equals(request.username()) || !"1234".equals(request.password())) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid username or password"));
        }

        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        String token = Jwts.builder()
                .subject(request.username())
                .claim("role", "USER")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .signWith(key)
                .compact();

        return ResponseEntity.ok(Map.of(
                "token", token,
                "type", "Bearer",
                "username", request.username(),
                "expiresInMinutes", 60
        ));
    }

    public record LoginRequest(String username, String password) {}
}

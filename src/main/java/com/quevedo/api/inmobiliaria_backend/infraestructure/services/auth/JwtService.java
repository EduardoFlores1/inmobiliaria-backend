package com.quevedo.api.inmobiliaria_backend.infraestructure.services.auth;

import com.quevedo.api.inmobiliaria_backend.aplication.services.auth.IJwtService;
import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService implements IJwtService {

    @Value("${security.jwt.expiration-minutes}")
    private long EXPIRATION_MINUTES;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    @Override
    public String generateToken(Usuario usuario) {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expirationDate = new Date(issuedAt.getTime() + (EXPIRATION_MINUTES * 60 * 1000));

        return Jwts.builder()
                .claims(generateExtraClaims(usuario))
                .subject(usuario.getUsername())
                .issuedAt(issuedAt)
                .expiration(expirationDate)
                .header()
                .add("alg", "HS256")
                .add("typ", "JWT")
                .and()
                .signWith(generateKey(), Jwts.SIG.HS256)
                .compact();
    }

    @Override
    public String extractUsername(String token) {
        return extractPayload(token).getSubject();
    }

    private SecretKey generateKey() {
        byte[] secretAsBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(secretAsBytes);
    }

    private Claims extractPayload(String token) {
        return Jwts.parser().verifyWith(generateKey()).build()
                .parseSignedClaims(token).getPayload();
    }

    private Map<String, Object> generateExtraClaims(Usuario usuario) {

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("username", usuario.getUsername());
        extraClaims.put("role", usuario.getRol());

        return extraClaims;
    }
}

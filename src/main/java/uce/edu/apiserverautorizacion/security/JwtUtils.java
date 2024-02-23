package uce.edu.apiserverautorizacion.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    @Value("${app.jwtSemilla}")
    private String jwtSemilla;

    @Value("${app.jwtExpiration}")
    private int jwtExpiration;

    public String buildTokenJwt(String nombre) {
        return Jwts.builder().setSubject(nombre).setSubject("Hola Mundo").setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + this.jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, this.jwtSemilla).compact();
    }
}

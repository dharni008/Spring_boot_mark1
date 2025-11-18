package first_project.Spring_boot_mark1.Utils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class Jwtutil {

    private final String SECRET = "THIS IS A JWT TOKEN GENERATOR KEY";
    private final Integer ExpirationTime = 1000 * 60 * 60 * 24;
    @Getter
    private final Key SecretKey = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String GenerateToken(String email){
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ExpirationTime))
                .signWith(SecretKey, SignatureAlgorithm.HS256)
                .compact();
    }
    public Boolean validateToken(String Token){
        try {
            String email = extractEmail(Token);
            return true;
        }catch (JwtException jwtException){
            jwtException.printStackTrace();
            return false;
        }
    }

    public String extractEmail(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}

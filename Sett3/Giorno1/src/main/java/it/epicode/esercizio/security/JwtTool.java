package it.epicode.esercizio.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.epicode.esercizio.exception.UnauthorizedException;
import it.epicode.esercizio.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTool {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.duration}")
    private long duration;


    //crea token impostando data inizio, data fine, id utente e firma del token attraverso la chiave segreta
    public String createToken(User user) {
        return Jwts.builder().setIssuedAt(new Date(System.currentTimeMillis())).
                expiration(new Date(System.currentTimeMillis() + duration)).
                subject(String.valueOf(user.getId())).
                signWith(Keys.hmacShaKeyFor(secret.getBytes())).
                compact();
    }

    //effettua verifica token ricevuto. Verifica veridicita e scadenza
    public void verifyToken(String token) {
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).
                    build().parse(token);
        } catch (Exception e) {
            throw new UnauthorizedException("Error in authorization, relogin!");
        }
    }
}

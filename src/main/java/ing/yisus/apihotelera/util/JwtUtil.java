package ing.yisus.apihotelera.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtUtil {
    private final KeyPair keyPair;
    private PrivateKey privateKey;
    private PublicKey publicKey;
    @Value("${app.security.jwt.timeInMinutes}")
    private Long expirationTime; // 1 hour in milliseconds

    @PostConstruct
    public void initKeys() {
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Duration.ofMinutes(expirationTime).toMillis()))
                .signWith(privateKey, Jwts.SIG.RS256)
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            return claims.getExpiration().before(new Date (System.currentTimeMillis())) && claims.getSubject() != null;
        } catch (JwtException | IllegalArgumentException _) {
            return false;
        }
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(publicKey)
                .build().parseSignedClaims(token).getPayload();
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = getClaimsFromToken(token);
        return claimsTFunction.apply(claims);
    }

    public String getUserNameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
}

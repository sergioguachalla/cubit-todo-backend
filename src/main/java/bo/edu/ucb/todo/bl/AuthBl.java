package bo.edu.ucb.todo.bl;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.JWT;
import java.util.Date;
import bo.edu.ucb.todo.dto.LoginDto;
import bo.edu.ucb.todo.dto.TokenDto;

public class AuthBl {

    public static final String KEY = "TigreCampeon2023";

    public TokenDto login(LoginDto login) {
        if ("jperez".equals(login.getUsername()) &&
        "12345678".equals(login.getPassword())) {
            TokenDto tokenDto = new TokenDto();
            tokenDto.setAuthToken(generateToken(100, "Juan Perez", "AUTH", 30));
            tokenDto.setRefreshToken(generateToken(100, "Juan Perez", "REFRESH", 60));
            return tokenDto;
        } else {
            return null;
        }

    }

    private String  generateToken(Integer userId, String name, String type, int minutes) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            String token = JWT.create()
                .withIssuer("www.ucb.edu.bo")
                .withClaim("userId", userId)
                .withClaim("type", type)
                .withClaim("name", name)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * minutes)) // 24 horas
                .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            System.out.println("Error al generar el token " + userId + " " + name + " " + type + " " + minutes);
            throw new RuntimeException("Error al generar el token", exception);
        }
    }

    public boolean validateToken(String token) {
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                // specify an specific claim validations
                .withIssuer("auth0")
                // reusable verifier instance
                .build();
                
            decodedJWT = verifier.verify(token);
        } catch (JWTVerificationException exception){
            // Invalid signature/claims
        }
    }
}
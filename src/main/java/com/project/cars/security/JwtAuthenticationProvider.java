package com.project.cars.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.project.cars.domain.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

@Component
public class JwtAuthenticationProvider {

    /**
     * Secret key for authentication
     */
    @Value("${jwt.secret.key}")
    private String secretKey;

    /**
     * List of JWT credentials
     */
    private HashMap<String, CustomerDto> listToken = new HashMap<>();

    public String createToken(CustomerDto customerJwt) {

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hora en milisegundos

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        String tokenCreated = JWT.create()
                .withClaim("cardId", customerJwt.getCardId())
                .withClaim("fullname", customerJwt.getFullName())
                .withClaim("numberCellPhone", String.valueOf(customerJwt.getNumberCellPhone()))
                .withClaim("email", customerJwt.getEmail())
                .withClaim("rol", customerJwt.getRol())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);

        listToken.put(tokenCreated, customerJwt);

        return tokenCreated;
    }

    public Authentication validateToken(String token) throws AuthenticationException {

        JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);

        CustomerDto exists = listToken.get( token );

        if (exists == null) {
            throw new BadCredentialsException("The user is not registered");
        }

        HashSet<SimpleGrantedAuthority> rolesAndAuthorities = new HashSet<>();
        rolesAndAuthorities.add(new SimpleGrantedAuthority("ROLE_" + exists.getRol()));

        return new UsernamePasswordAuthenticationToken(exists, token, rolesAndAuthorities);
    }

    public String deleteToken(String jwt) {

        if (!listToken.containsKey(jwt)) {
            return "No existe token";
        }

        listToken.remove(jwt);
        return "Sesión cerrada exitosamente";
    }

}

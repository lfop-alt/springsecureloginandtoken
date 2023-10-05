package com.lfop.assembleia.services;

import com.auth0.jwt.algorithms.Algorithm;
import com.lfop.assembleia.model.UserModel;
import com.auth0.jwt.JWT;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {
    public String gerarToken(UserModel userModel) {
        return JWT.create().withIssuer("Posts")
                .withSubject(userModel.getUsername())
                .withClaim("id", userModel.getId())
                .withExpiresAt(LocalDateTime.now().plusMinutes(400)
                        .toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("DEPOISIREIMUDAR"));
    }

    public String getSubject(String token) {

        return JWT.require(Algorithm.HMAC256("DEPOISIREIMUDAR")).withIssuer("Posts").build().verify(token).getSubject();
    }
}

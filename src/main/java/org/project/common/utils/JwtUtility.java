package org.project.common.utils;

import io.smallrye.jwt.build.Jwt;

import java.time.Instant;
import java.util.Set;

public class JwtUtility {
    private static final String ISSUER = "substar-api";

    public static String createJWT(String username, Set<String> roles) {
        return Jwt.issuer(ISSUER)
                .upn(username)
                .groups(roles)
                .expiresAt(Instant.now().plusSeconds(3600))
                .sign();
    }
}

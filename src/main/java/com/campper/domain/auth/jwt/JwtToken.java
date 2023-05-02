package com.campper.domain.auth.jwt;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class JwtToken {
    private final String jwtAccessToken;
    private final String jwtRefreshToken;

    @Builder
    public JwtToken(String jwtAccessToken, String jwtRefreshToken, Date expRT) {
        this.jwtAccessToken = jwtAccessToken;
        this.jwtRefreshToken = jwtRefreshToken;
    }
}

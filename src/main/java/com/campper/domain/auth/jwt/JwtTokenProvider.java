package com.campper.domain.auth.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.security.Key;
import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${JWT_SECRET_KEY}")
    private String secretKey;
    @Value("${AUTHORITIES_KEY}")
    private String AUTHORITIES_KEY;

    /**
     * 토큰 유효 시간
     * 60분, 2주
     */
    private static final long JWT_EXPIRATION_TIME = 1000L * 60 * 60;
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = 1000L * 60 * 60 * 24 * 14;


    public Key getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    /**
     * 토큰 생성
     */
    public JwtToken generateToken(String authKey)
            throws HttpServerErrorException.InternalServerError {
        final Date now = new Date();
        return JwtToken.builder()
                .jwtAccessToken(generateAccessToken(authKey, now))
                .jwtRefreshToken(generateRefreshToken(now))
                .build();
    }

    public String generateAccessToken(String authKey, Date now) {
        final Date accessTokenExpire = new Date(now.getTime() + JWT_EXPIRATION_TIME);

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("Campper")
                .setIssuedAt(now) /**생성 일자*/
                .setSubject(authKey)
                .claim(AUTHORITIES_KEY, authKey) /**권한 설정*/
                .setExpiration(accessTokenExpire) /**만료 일자*/
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateRefreshToken(Date now) {
        final Date refreshTokenExpire = new Date(now.getTime() + REFRESH_TOKEN_EXPIRATION_TIME);

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("Campper")
                .setExpiration(refreshTokenExpire)
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }

}

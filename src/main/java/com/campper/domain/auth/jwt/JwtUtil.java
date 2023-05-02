package com.campper.domain.auth.jwt;

import com.campper.global.common.error.ErrorCode;
import com.campper.global.common.error.exception.UnauthorizedException;
import com.campper.global.security.CustomUserDetailServiceImpl;
import com.campper.global.security.CustomUserDetails;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;


@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {
    @Value("${JWT_SECRET_KEY}")
    private String secretKey;
    @Value("${AUTHORITIES_KEY}")
    private String AUTHORITIES_KEY;

    private final CustomUserDetailServiceImpl customUserDetailService;
    public Key getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    /**토큰 유효성 확인*/

    /**
     * JWT 토큰을 복호화하여 토큰에 들어있는 정보를 꺼내는 메서드
     */
    public Authentication getAuthentication(String token) {
        /** 토큰 복호화*/
        /** 사용자 속성값*/
        Claims claims = parseClaims(token);

        if (claims.get(AUTHORITIES_KEY) == null) {
            throw new UnauthorizedException(ErrorCode.INVALID_AUTH_TOKEN);
        }
        ;
        log.info(claims.getSubject());
        /**userDetails 반환*/
        CustomUserDetails userDetails = (CustomUserDetails)customUserDetailService.loadUserByUsername(claims.getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails.getUser(), null,
                userDetails.getAuthorities());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSecretKey()).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty.", e);
        }
        return false;
    }

    private Claims parseClaims(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(getSecretKey()).build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}

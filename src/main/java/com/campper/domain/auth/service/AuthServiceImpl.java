package com.campper.domain.auth.service;


import com.campper.domain.auth.dto.request.PostJwtDto;
import com.campper.domain.auth.dto.request.PostLoginDto;
import com.campper.domain.auth.dto.response.GetJwtDto;
import com.campper.domain.auth.jwt.JwtToken;
import com.campper.domain.auth.jwt.JwtTokenProvider;
import com.campper.domain.auth.jwt.JwtUtil;
import com.campper.domain.users.entity.User;
import com.campper.domain.users.repository.UserRepository;
import com.campper.global.common.error.ErrorCode;
import com.campper.global.common.error.exception.BadRequestException;
import com.campper.global.common.error.exception.UnauthorizedException;
import com.campper.infra.redis.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {
    private final JwtUtil jwtUtil;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisUtil redisUtil;
    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Override
    public GetJwtDto login(PostLoginDto postLoginDto) {
        UsernamePasswordAuthenticationToken authentication = postLoginDto.toAuthentication();

        if (!userRepository.existByAuthKey(postLoginDto.getAuthKey())) {
            throw new BadRequestException(ErrorCode.USER_NOT_FOUND);
        }

        authenticationManagerBuilder.getObject().authenticate(authentication);

        final JwtToken jwtToken = jwtTokenProvider.generateToken(postLoginDto.getAuthKey());

        redisUtil.set("RT:" + jwtToken.getJwtRefreshToken(), postLoginDto.getAuthKey(), 1000L * 60 * 60 * 24 * 14);

        return GetJwtDto.builder()
                .accessToken(jwtToken.getJwtAccessToken())
                .refreshToken(jwtToken.getJwtRefreshToken())
                .build();
    }

    @Override
    public void logout(PostJwtDto postJwtDto, User user) {
        /**refreshToken 만료 여부 확인*/
        if (!redisUtil.hasKey("RT:" + postJwtDto.getRefreshToken())) {
            throw new UnauthorizedException(ErrorCode.INVALID_REFRESH_TOKEN);
        }

        redisUtil.delete("RT:" + postJwtDto.getRefreshToken());

        /**accessToken 블랙리스트 등록*/
        redisUtil.setBlackList("BL:" + postJwtDto.getAccessToken(), "logout", jwtUtil.getExpiration(postJwtDto.getAccessToken()));

        SecurityContextHolder.clearContext();
    }

    @Override
    public GetJwtDto reissue(PostJwtDto postJwtDto) {
        /**accessToken 유효성 확인*/
        if (jwtUtil.validateToken(postJwtDto.getAccessToken())) {
            throw new BadRequestException(ErrorCode.BAD_REQUEST);
        }

        /**refreshToken 유효성 확인*/
        if (!jwtUtil.validateToken(postJwtDto.getRefreshToken())) {
            throw new UnauthorizedException(ErrorCode.INVALID_TOKEN);
        }

        /**refreshToken 만료 여부 확인*/
        if (!redisUtil.hasKey("RT:" + postJwtDto.getRefreshToken())) {
            throw new UnauthorizedException(ErrorCode.INVALID_REFRESH_TOKEN);
        }

        String authKey = (String) redisUtil.get("RT:" + postJwtDto.getRefreshToken());

        return GetJwtDto.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(authKey, new Date()))
                .refreshToken(postJwtDto.getRefreshToken())
                .build();
    }
}

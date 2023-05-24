package com.campper.domain.auth.service;


import com.campper.domain.auth.dto.request.PostJwtDto;
import com.campper.domain.auth.dto.request.PostLoginDto;
import com.campper.domain.auth.dto.response.GetJwtDto;
import com.campper.domain.auth.jwt.JwtToken;
import com.campper.domain.auth.jwt.JwtTokenProvider;
import com.campper.domain.auth.jwt.JwtUtil;
import com.campper.domain.auth.jwt.inmemory.reissue.RefreshTokenRepository;
import com.campper.domain.auth.jwt.inmemory.reissue.service.RefreshTokenService;
import com.campper.domain.users.entity.User;
import com.campper.domain.users.repository.UserRepository;
import com.campper.global.common.error.ErrorCode;
import com.campper.global.common.error.exception.BadRequestException;
import com.campper.global.common.error.exception.UnauthorizedException;
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
    private final RefreshTokenRepository refreshTokenRepository;
    private final RefreshTokenService refreshTokenService;
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

        refreshTokenService.saveRefreshToken(jwtToken.getJwtRefreshToken(), postLoginDto.getAuthKey());

        return GetJwtDto.builder()
                .accessToken(jwtToken.getJwtAccessToken())
                .refreshToken(jwtToken.getJwtRefreshToken())
                .build();
    }

    @Override
    public void logout(PostJwtDto postJwtDto, User user) {
        /**refreshToken 만료 여부 확인*/
        if (!refreshTokenRepository.existsById(postJwtDto.getRefreshToken())) {
            throw new UnauthorizedException(ErrorCode.INVALID_REFRESH_TOKEN);
        }

        if(refreshTokenService.findByRefreshToken(postJwtDto.getRefreshToken()).getAuthKey()!= user.getAuthKey()){
            throw new UnauthorizedException(ErrorCode.UNAUTHORIZED_ACCESS);
        }

        refreshTokenRepository.deleteById(postJwtDto.getRefreshToken());
        SecurityContextHolder.clearContext();
    }

    @Override
    public GetJwtDto reissue(PostJwtDto postJwtDto) {
        /**refreshToken 유효성 확인*/
        if (!jwtUtil.validateToken(postJwtDto.getRefreshToken())) {
            throw new UnauthorizedException(ErrorCode.INVALID_TOKEN);
        }

        /**refreshToken 만료 여부 확인*/
        if (!refreshTokenRepository.existsById(postJwtDto.getRefreshToken())) {
            throw new UnauthorizedException(ErrorCode.INVALID_REFRESH_TOKEN);
        }

        String authKey = refreshTokenService.findByRefreshToken(postJwtDto.getRefreshToken()).getAuthKey();

        return GetJwtDto.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(authKey, new Date()))
                .refreshToken(postJwtDto.getRefreshToken())
                .build();
    }
}

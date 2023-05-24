package com.campper.domain.auth.service;


import com.campper.domain.auth.dto.request.PostJwtDto;
import com.campper.domain.auth.dto.request.PostLoginDto;
import com.campper.domain.auth.dto.response.GetJwtDto;
import com.campper.domain.auth.jwt.JwtToken;
import com.campper.domain.auth.jwt.JwtTokenProvider;
import com.campper.domain.users.entity.User;
import com.campper.domain.users.repository.UserRepository;
import com.campper.global.common.error.ErrorCode;
import com.campper.global.common.error.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {
    private final JwtTokenProvider jwtTokenProvider;
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
        return GetJwtDto.builder()
                .accessToken(jwtToken.getJwtAccessToken())
                .refreshToken(jwtToken.getJwtRefreshToken())
                .build();
    }

    @Override
    public void logout(User user) {
        //TODO: 리프레시 토큰 삭제

    }

    @Override
    public GetJwtDto reissue(PostJwtDto postJwtDto) {
        return GetJwtDto.builder()
//                .accessToken(jwtTokenProvider.generateAccessToken())
                .refreshToken(postJwtDto.getRefreshToken())
                .build();
    }
}

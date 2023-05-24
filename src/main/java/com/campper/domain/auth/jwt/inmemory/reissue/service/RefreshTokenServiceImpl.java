package com.campper.domain.auth.jwt.inmemory.reissue.service;

import com.campper.domain.auth.jwt.inmemory.reissue.RefreshToken;
import com.campper.domain.auth.jwt.inmemory.reissue.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements com.campper.domain.auth.jwt.inmemory.reissue.service.RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    @Transactional
    public void saveRefreshToken(String refreshToken, String authKey) {
        RefreshToken token = RefreshToken.builder()
                .jwtRefreshToken(refreshToken)
                .authKey(authKey)
                .build();
        refreshTokenRepository.save(token);
    }

    @Override
    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findById(refreshToken).orElseThrow();
    }
}

package com.campper.domain.auth.jwt.inmemory.reissue.service;

import com.campper.domain.auth.jwt.inmemory.reissue.RefreshToken;
import org.springframework.stereotype.Service;

@Service
public interface RefreshTokenService {
    RefreshToken findByRefreshToken(String refreshToken);
    void saveRefreshToken(String refreshToken, String authKey);
}

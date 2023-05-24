package com.campper.domain.auth.jwt.inmemory.blackList;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor
@RedisHash(value = "accessToken", timeToLive = 1000L * 60 * 60 * 24 * 14)
public class AccessToken {
    @Id
    @Indexed
    private String accessToken;

    @Builder
    public AccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}

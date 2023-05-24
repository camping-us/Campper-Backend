package com.campper.domain.auth.jwt.inmemory.reissue;

import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken,String> {
}

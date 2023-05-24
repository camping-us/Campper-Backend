package com.campper.domain.auth.jwt.inmemory.blackList;

import org.springframework.data.repository.CrudRepository;

public interface AccessTokenRepository extends CrudRepository<AccessToken, String> {
}

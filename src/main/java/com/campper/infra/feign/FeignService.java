package com.campper.infra.feign;


import com.campper.domain.users.entity.User;

public interface FeignService {
    void loadOpenApi(User user);
}

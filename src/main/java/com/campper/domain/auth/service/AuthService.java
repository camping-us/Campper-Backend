package com.campper.domain.auth.service;

import com.campper.domain.auth.dto.request.PostJwtDto;
import com.campper.domain.auth.dto.request.PostLoginDto;
import com.campper.domain.auth.dto.response.GetJwtDto;
import com.campper.domain.users.entity.User;

public interface AuthService {
    GetJwtDto login(PostLoginDto postLoginDto);

    void logout(PostJwtDto postJwtDto, User user);

    GetJwtDto reissue(PostJwtDto postJwtDto);
}

package com.campper.domain.users.service;

import com.campper.domain.users.dto.request.DelUserDto;
import com.campper.domain.users.dto.request.PostUserDto;
import com.campper.domain.users.dto.request.PutUserProfileDto;
import com.campper.domain.users.dto.request.PutUserPwdDto;
import com.campper.domain.users.dto.response.GetUserProfileDto;

public interface UserService {

    boolean getAuthKeyDuplicate(String authKey);

    void join(PostUserDto postUserDto);

    void updatePwd(PutUserPwdDto putUserPwdDto, String authKey);

    GetUserProfileDto updateProfile(PutUserProfileDto putUserProfileDto, String authKey);

    GetUserProfileDto getUserProfile(String authKey);

    void withdraw(DelUserDto delUserDto, String authKey);
}
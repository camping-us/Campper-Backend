package com.campper.domain.users.service;

import com.campper.domain.users.dto.request.PostUserDto;
import com.campper.domain.users.dto.request.PutUserProfileDto;
import com.campper.domain.users.dto.request.PutUserPwdDto;
import com.campper.domain.users.dto.response.GetUserProfileDto;
import com.campper.domain.users.entity.User;

public interface UserService {

    void getAuthKeyDuplicate(String authKey);

    void join(PostUserDto postUserDto);

    void updatePwd(PutUserPwdDto putUserPwdDto, User user);

    GetUserProfileDto updateProfile(PutUserProfileDto putUserProfileDto, User user);

    GetUserProfileDto getUserProfile(User user);

    void checkPwd(String pwd, User user);

    void withdraw(User user);
}
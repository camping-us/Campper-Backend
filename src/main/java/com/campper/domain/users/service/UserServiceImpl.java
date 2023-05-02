package com.campper.domain.users.service;

import com.campper.domain.users.dto.request.DelUserDto;
import com.campper.domain.users.dto.request.PostUserDto;
import com.campper.domain.users.dto.request.PutUserProfileDto;
import com.campper.domain.users.dto.request.PutUserPwdDto;
import com.campper.domain.users.dto.response.GetUserProfileDto;
import com.campper.domain.users.entity.Role;
import com.campper.domain.users.entity.User;
import com.campper.domain.users.repository.UserRepository;
import com.campper.global.common.error.ErrorCode;
import com.campper.global.common.error.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public boolean getAuthKeyDuplicate(String authKey) {
        return userRepository.existByAuthKey(authKey);
    }

    @Override
    @Transactional
    public void join(PostUserDto postUserDto) {

        User user = User.builder()
                .authKey(postUserDto.getAuthId())
                .email(postUserDto.getEmail())
                .pwd(postUserDto.getPwd())
                .nickName(postUserDto.getNickName())
                .birth(postUserDto.getBirth())
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updatePwd(PutUserPwdDto putUserPwdDto, String authKey) {
        User user = userRepository.findByAuthKey(authKey)
                .orElseThrow();

        if(!user.getPwd().equals(putUserPwdDto.getPwd())){
            throw new UnauthorizedException(ErrorCode.UNAUTHORIZED_ACCESS);
        }

        user.updatePwd(putUserPwdDto.getNewPwd());

        userRepository.updatePwd(user);
    }

    @Override
    @Transactional
    public GetUserProfileDto updateProfile(PutUserProfileDto putUserProfileDto, String authKey) {
        User user = userRepository.findByAuthKey(authKey)
                .orElseThrow();

        user.updateProfile(putUserProfileDto.getNickName(), putUserProfileDto.getProfileImg());

        userRepository.updateProfile(user);

        return GetUserProfileDto.fromEntity(user);
    }

    @Override
    public GetUserProfileDto getUserProfile(String authKey) {
        User user = userRepository.findByAuthKey(authKey)
                .orElseThrow();

        return GetUserProfileDto.fromEntity(user);
    }

    @Override
    @Transactional
    public void withdraw(DelUserDto delUserDto, String authKey) {
        User user = userRepository.findByAuthKey(authKey)
                .orElseThrow();

        //TODO: 인코딩 된 비밀번호와 같은지 확인 필요
        if(!user.getAuthKey().equals(delUserDto.getAuthId())){
            throw new UnauthorizedException(ErrorCode.UNAUTHORIZED_ACCESS);
        }

        user.updateIsDeleted();

        userRepository.delete(user);
    }
}
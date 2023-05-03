package com.campper.domain.users.service;

import com.campper.domain.users.dto.request.PostUserDto;
import com.campper.domain.users.dto.request.PutUserProfileDto;
import com.campper.domain.users.dto.request.PutUserPwdDto;
import com.campper.domain.users.dto.response.GetUserProfileDto;
import com.campper.domain.users.entity.Role;
import com.campper.domain.users.entity.User;
import com.campper.domain.users.repository.UserRepository;
import com.campper.global.common.error.ErrorCode;
import com.campper.global.common.error.exception.BadRequestException;
import com.campper.global.common.error.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void getAuthKeyDuplicate(String authKey) {
        if (userRepository.existByAuthKey(authKey)) {
            throw new BadRequestException(ErrorCode.DUPLICATE_AUTHKEY);
        }
    }

    @Override
    @Transactional
    public void join(PostUserDto postUserDto) {

        User user = User.builder()
                .authKey(postUserDto.getAuthKey())
                .email(postUserDto.getEmail())
                .pwd(passwordEncoder.encode(postUserDto.getPwd()))
                .nickName(postUserDto.getNickName())
                .birth(postUserDto.getBirth())
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updatePwd(PutUserPwdDto putUserPwdDto, User user) {
        if (!user.getPwd().equals(putUserPwdDto.getPwd())) {
            throw new UnauthorizedException(ErrorCode.UNAUTHORIZED_ACCESS);
        }

        user.updatePwd(putUserPwdDto.getNewPwd());

        userRepository.updatePwd(user);
    }

    @Override
    @Transactional
    public GetUserProfileDto updateProfile(PutUserProfileDto putUserProfileDto, User user) {

        user.updateProfile(putUserProfileDto.getNickName(), putUserProfileDto.getProfileImg());
        userRepository.updateProfile(user);
        return GetUserProfileDto.fromEntity(user);
    }

    @Override
    public GetUserProfileDto getUserProfile(User user) {
        return GetUserProfileDto.fromEntity(user);
    }

    @Override
    public void checkPwd(String pwd, User user) {
        if (!passwordEncoder.matches(pwd, user.getPwd())) {
            throw new BadRequestException(ErrorCode.INVALID_PASSWORD);
        }
    }

    @Override
    @Transactional
    public void withdraw(User user) {
        user.updateIsDeleted();
        userRepository.delete(user);
    }
}

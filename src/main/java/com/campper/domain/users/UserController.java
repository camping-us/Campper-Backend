package com.campper.domain.users;

import com.campper.domain.users.dto.request.DelUserDto;
import com.campper.domain.users.dto.request.PostUserDto;
import com.campper.domain.users.dto.request.PutUserProfileDto;
import com.campper.domain.users.dto.request.PutUserPwdDto;
import com.campper.domain.users.dto.response.GetUserProfileDto;
import com.campper.domain.users.entity.User;
import com.campper.domain.users.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
@Api(tags = "사용자")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    @Operation(summary = "아이디 중복 확인 요청", description = "아이디 중복 확인 API 입니다.")
    public void getAuthKeyDuplicate(@RequestParam String authKey) {
        userService.getAuthKeyDuplicate(authKey);
    }

    @PostMapping("/")
    @Operation(summary = "회원가입 요청", description = "회원가입 요청 API 입니다.")
    public void postUser(@RequestBody @Valid PostUserDto postUserDto) {
        userService.join(postUserDto);
    }

    @PutMapping("/")
    @Operation(summary = "비밀번호 수정 요청", description = "비밀번호 수정 요청 API 입니다.")
    public void putUser(@RequestBody @Valid PutUserPwdDto putUserPwdDto, @AuthenticationPrincipal User user) {
        userService.updatePwd(putUserPwdDto, user);
    }

    @PutMapping("/profile")
    @Operation(summary = "프로필 수정 요청", description = "프로필 수정 요청 API 입니다.")
    public GetUserProfileDto putProfile(@RequestBody @Valid PutUserProfileDto putUserProfileDto, @AuthenticationPrincipal User user) {
        return userService.updateProfile(putUserProfileDto, user);
    }

    @GetMapping("/profile")
    @Operation(summary = "프로필 요청", description = "프로필 요청 API 입니다.")
    public GetUserProfileDto getProfile(@AuthenticationPrincipal User user) {
        return userService.getUserProfile(user);
    }

    @DeleteMapping("/")
    @Operation(summary = "회원 탈퇴 요청", description = "회원 탈퇴 API 입니다.")
    public void delUser(@RequestBody @Valid DelUserDto delUserDto, @AuthenticationPrincipal User user) {
        userService.withdraw(delUserDto, user);
    }
}

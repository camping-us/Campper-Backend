package com.campper.domain.auth;


import com.campper.domain.auth.dto.request.PostJwtDto;
import com.campper.domain.auth.dto.request.PostLoginDto;
import com.campper.domain.auth.dto.response.GetJwtDto;
import com.campper.domain.auth.service.AuthService;
import com.campper.domain.users.entity.User;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = "인증")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "로그인 요청", description = "로그인 요청 API 입니다.")
    public GetJwtDto login(@RequestBody @Valid PostLoginDto postLoginDto) {
        return authService.login(postLoginDto);
    }

    @PostMapping("/logout")
    @Operation(summary = "로그아웃 요청", description = "로그아웃 요청 API 입니다.")
    public void logout(@RequestBody @Valid PostJwtDto postJwtDto, @AuthenticationPrincipal User user) {
        authService.logout(postJwtDto, user);
    }

    @PostMapping("/reissue")
    @Operation(summary = "어세스토큰 재발행 요청", description = "어세스토큰 재발행 요청 API 입니다.")
    public GetJwtDto reissue(@RequestBody @Valid PostJwtDto postJwtDto) {
        return authService.reissue(postJwtDto);
    }
}

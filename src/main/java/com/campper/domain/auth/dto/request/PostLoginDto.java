package com.campper.domain.auth.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class PostLoginDto {
    @ApiModelProperty(value = "사용자 아이디", example = "U123456789")
    @NotNull
    private String authKey;
    @ApiModelProperty(value = "사용자 비밀번호", example = "U123456789!")
    @NotNull
    private String pwd;

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(authKey, pwd);
    }
}

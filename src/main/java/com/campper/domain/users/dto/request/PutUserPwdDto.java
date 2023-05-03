package com.campper.domain.users.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class PutUserPwdDto {
    @ApiModelProperty(value = "사용자 기존 비밀번호", example = "U12345!")
    @NotNull
    private String pwd;
    @ApiModelProperty(value = "사용자 새 비밀번호", example = "U12345!")
    @NotNull
    private String newPwd;
}

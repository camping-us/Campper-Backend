package com.campper.domain.users.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class DelUserDto {
    @ApiModelProperty(value = "사용자 아이디", example = "U12345")
    @NotNull
    private String authId;
    @ApiModelProperty(value = "사용자 비밀번호", example = "U12345!")
    @NotNull
    private String pwd;
}

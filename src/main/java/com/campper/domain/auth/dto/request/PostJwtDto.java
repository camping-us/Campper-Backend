package com.campper.domain.auth.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class PostJwtDto {
    @ApiModelProperty(value = "accessToken", example = "abcdedwfopjapoewjpfaeijewfijeoaewopijfaowe")
    @NotNull
    private String accessToken;
    @ApiModelProperty(value = "refreshToken", example = "abcdedwfopjapoewjpfaeijewfijeoaewopijfaowe")
    @NotNull
    private String refreshToken;
}

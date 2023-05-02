package com.campper.domain.auth.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAccessTokenDto {
    @ApiModelProperty(notes = "accessToken", required = true)
    private String accessToken;

    public GetAccessTokenDto(String accessToken) {
        this.accessToken = accessToken;
    }
}

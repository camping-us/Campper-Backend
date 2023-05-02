package com.campper.domain.auth.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetJwtDto {
    @ApiModelProperty(notes = "accessToken", required = true)
    private String accessToken;
    @ApiModelProperty(notes = "refreshToken", required = true)
    private String refreshToken;

    @Builder
    public GetJwtDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}

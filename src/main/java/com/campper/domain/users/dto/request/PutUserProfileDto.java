package com.campper.domain.users.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PutUserProfileDto {
    @ApiModelProperty(value = "사용자 별명", example = "UNAME12345")
    private String nickName;
    @ApiModelProperty(value = "사용자 별명", example = "U12345")
    private String profileImg;
}

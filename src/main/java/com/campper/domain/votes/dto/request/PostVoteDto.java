package com.campper.domain.votes.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
public class PostVoteDto {
    @ApiModelProperty(value = "전체 별점", example = "5")
    @NotNull
    @Positive
    @Max(value = 5)
    private int total;

    @ApiModelProperty(value = "위치 별점", example = "5")
    @NotNull
    @Positive
    @Max(value = 5)
    private int location;

    @ApiModelProperty(value = "청결도 별점", example = "5")
    @NotNull
    @Positive
    @Max(value = 5)
    private int cleanliness;

    @ApiModelProperty(value = "친절도 별점", example = "5")
    @NotNull
    @Positive
    @Max(value = 5)
    private int kindness;

    @ApiModelProperty(value = "금액 별점", example = "5")
    @NotNull
    @Positive
    @Max(value = 5)
    private int price;

    @ApiModelProperty(value = "부대시설 별점", example = "5")
    @NotNull
    @Positive
    @Max(value = 5)
    private int facilities;
}

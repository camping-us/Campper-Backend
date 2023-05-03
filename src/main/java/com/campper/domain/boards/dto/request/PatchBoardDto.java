package com.campper.domain.boards.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class PatchBoardDto {

    @ApiModelProperty(value = "게시판 제목", example = "강아지의 특징")
    @NotNull
    @Min(1) @Max(20)
    private String title;
    @ApiModelProperty(value = "게시판 내용", example = "강아지는 귀여워요")
    @NotNull
    @Min(1) @Max(200)
    private String content;


}

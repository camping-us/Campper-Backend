package com.campper.domain.boards.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatchBoardDto {

    @ApiModelProperty(value = "게시판 제목", example = "강아지의 특징")
    @NotNull
    private String title;
    @ApiModelProperty(value = "게시판 내용", example = "강아지는 귀여워요")
    @NotNull
    private String content;
}

package com.campper.domain.boards.dto.request;

import com.campper.domain.boards.entity.Category;
import com.campper.global.common.valid.EnumValid;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class BoardParameterDto {

    @ApiModelProperty(value = "현재 페이지 번호", example = "1")
    private int pg=1;
    @ApiModelProperty(value = "페이지당 글갯수", example = "20")
    private int spp=20;
    @ApiModelProperty(value = "페이지의 시작 글번호", example = "1")
    private int start=1;
    @ApiModelProperty(value = "게시판 종류", example = "자유게시판")
    @EnumValid
    private Category category;
}
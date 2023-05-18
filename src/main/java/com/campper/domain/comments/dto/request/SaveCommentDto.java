package com.campper.domain.comments.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class SaveCommentDto {

    @ApiModelProperty(value = "게시판 번호", example = "7")
    @NotNull
    private Long boardId;

    @ApiModelProperty(value = "댓글 내용", example = "강아지는 너무 귀여워요")
    @NotNull
    private String content;
}

package com.campper.domain.comments.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentParameterDto {

    @ApiModelProperty(value = "게시글 번호", example = "1")
    private int boardId;
    @ApiModelProperty(value = "현재 페이지 번호", example = "1")
    private int pg=1;
    @ApiModelProperty(value = "페이지당 댓글 개수", example = "10")
    private int spp=10;
    @ApiModelProperty(value = "페이지의 시작 글번호", example = "1")
    private int start=1;
}

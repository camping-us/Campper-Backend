package com.campper.domain.comments.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveCommentDto {

    @ApiModelProperty(value = "댓글 내용", example = "강아지는 너무 귀여워요")
    @NotNull
    private String content;
}

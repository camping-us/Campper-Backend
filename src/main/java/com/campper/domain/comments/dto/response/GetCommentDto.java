package com.campper.domain.comments.dto.response;

import com.campper.domain.comments.entity.Comment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class GetCommentDto {

    @ApiModelProperty(value = "댓글 번호", example = "25")
    @NotNull
    private Long id;

    @ApiModelProperty(value = "댓글 작성자")
    private String userName;

    @ApiModelProperty(value = "댓글 내용", example = "강아지는 너무 귀여워요")
    @NotNull
    private String content;

    @Builder
    public GetCommentDto(Long id, String userName, String content) {
        this.id=id;
        this.userName=userName;
        this.content=content;
    }

    public static GetCommentDto fromEntity(Comment comment, String userName) {
        return GetCommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .userName(userName)
                .build();
    }
}

package com.campper.domain.comments.dto.response;

import com.campper.domain.comments.entity.Comment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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

    @ApiModelProperty(value = "좋아요 개수", example = "11")
    @NotNull
    private int likeCnt;

    @ApiModelProperty(value = "댓글 작성자 아이디")
    private Long userId;

    @ApiModelProperty(value = "작성일", example = "2023-05-23T11:36:58")
    @NotNull
    private LocalDateTime createdAt;

    @Builder
    public GetCommentDto(Long id, String userName, String content, int likeCnt, Long userId, LocalDateTime createdAt) {
        this.id=id;
        this.userName=userName;
        this.content=content;
        this.likeCnt = likeCnt;
        this.userId=userId;
        this.createdAt=createdAt;
    }

    public static GetCommentDto fromEntity(Comment comment, String userName, Long userId) {
        return GetCommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .likeCnt(comment.getLikeCnt())
                .userName(userName)
                .userId(userId)
                .createdAt(comment.getCreatedAt())
                .build();
    }
}

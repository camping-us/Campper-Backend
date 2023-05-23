package com.campper.domain.boards.dto.response;

import com.campper.domain.boards.entity.Board;
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
public class GetBoardDto {

    @ApiModelProperty(value = "게시판 번호", example = "25")
    @NotNull
    private Long id;

    @ApiModelProperty(value = "게시글 작성자")
    private String userName;

    @ApiModelProperty(value = "게시글 제목", example = "강아지의 특징")
    @NotNull
    private String title;

    @ApiModelProperty(value = "게시글 내용", example = "강아지는 귀여워요")
    @NotNull
    private String content;

    @ApiModelProperty(value = "게시글 좋아요 수", example = "10")
    @NotNull
    private int likeCnt;

    @ApiModelProperty(value = "작성일", example = "2023-05-23T11:36:58")
    @NotNull
    private LocalDateTime createdAt;

    @Builder
    public GetBoardDto(Long id, String userName, String title, String content, int likeCnt, LocalDateTime createdAt) {
        this.id=id;
        this.userName=userName;
        this.title=title;
        this.content=content;
        this.likeCnt=likeCnt;
        this.createdAt=createdAt;
    }

    public static GetBoardDto fromEntity(Board board, String userName) {
        return GetBoardDto.builder()
                .id(board.getId())
                .userName(userName)
                .title(board.getTitle())
                .content(board.getContent())
                .likeCnt(board.getLikeCnt())
                .createdAt(board.getCreatedAt())
                .build();
    }

//    @ApiModelProperty(value = "조회수")
//    private int hit;
//    @ApiModelProperty(value = "작성일")
//    private String regTime;
}

package com.campper.domain.boards.dto.response;

import com.campper.domain.boards.entity.Board;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

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

    @Builder
    public GetBoardDto(Long id, String userName, String title, String content) {
        this.id=id;
        this.userName=userName;
        this.title=title;
        this.content=content;
    }

    public static GetBoardDto fromEntity(Board board, String userName) {
        return GetBoardDto.builder()
                .id(board.getId())
                .userName(userName)
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }

//    @ApiModelProperty(value = "조회수")
//    private int hit;
//    @ApiModelProperty(value = "작성일")
//    private String regTime;
}

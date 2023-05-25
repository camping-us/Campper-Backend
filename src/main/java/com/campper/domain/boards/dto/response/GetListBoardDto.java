package com.campper.domain.boards.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class GetListBoardDto {

    @ApiModelProperty(value = "게시글 정보 배열", example = "{}")
    private List<GetBoardDto> boards;

    @ApiModelProperty(value = "게시글 전체 갯수", example = "20")
    private int boardCnt;

    @Builder
    public GetListBoardDto(List<GetBoardDto> boards, int boardCnt) {
        this.boards=boards;
        this.boardCnt=boardCnt;
    }
}

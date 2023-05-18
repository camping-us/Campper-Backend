package com.campper.domain.boards.dto.response;

import com.campper.domain.boards.entity.Board;
import com.campper.domain.boards.entity.Category;
import com.campper.domain.boards.entity.Image;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetBoardDetailDto {

    @ApiModelProperty(value = "게시글 번호", example = "25")
    @NotNull
    private Long id;
    @ApiModelProperty(value = "게시글 제목", example = "강아지의 특징")
    @NotNull
    private String title;
    @ApiModelProperty(value = "게시글 내용", example = "강아지는 귀여워요")
    @NotNull
    private String content;
    @ApiModelProperty(value = "게시글 종류", example = "FREE_BOARD")
    @NotNull
    private Category category;
    @ApiModelProperty(value = "좋아요 개수", example = "11")
    @NotNull
    private int likeCnt;
    @ApiModelProperty(value = "작성자", example = "보통이")
    @NotNull
    private String userName;

    @ApiModelProperty(value = "게시글 사진", example = "['https://avatars.githubusercontent.com/u/37575974']")
    private List<String> images;

    @Builder
    public GetBoardDetailDto(Long id, String title, String content, Category category, int likeCnt, String userName, List<String> images) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.likeCnt = likeCnt;
        this.userName = userName;
        this.images = images;
    }

    public static GetBoardDetailDto fromEntity(Board board, String userName, List<String> images) {
        return GetBoardDetailDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .category(board.getCategory())
                .likeCnt(board.getLikeCnt())
                .userName(userName)
                .images(images)
                .build();
    }
}

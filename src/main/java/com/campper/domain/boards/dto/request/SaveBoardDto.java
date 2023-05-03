package com.campper.domain.boards.dto.request;

import com.campper.domain.boards.entity.Category;
import com.campper.domain.boards.entity.Image;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
public class SaveBoardDto {

    @ApiModelProperty(value = "게시판 제목", example = "강아지의 특징")
    @NotNull
    private String title;
    @ApiModelProperty(value = "게시판 내용", example = "강아지는 귀여워요")
    @NotNull
    private String content;
    @ApiModelProperty(value = "게시판 종류", example = "FREE_BOARD")
    @NotNull
    private Category category;
    @ApiModelProperty(value = "게시판 사진", example = "['https://avatars.githubusercontent.com/u/37575974']")
    private List<String> images;

}

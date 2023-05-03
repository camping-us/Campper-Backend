package com.campper.domain.boards.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Image {

    private Long id;
    private String imageUrl;
    private Long boardId;

    @Builder
    public Image(Long id, String imageUrl, Long boardId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.boardId = boardId;
    }
}

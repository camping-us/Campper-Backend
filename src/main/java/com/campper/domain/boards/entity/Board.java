package com.campper.domain.boards.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Board {

    private Long id;
    private String title;
    private String content;
    private Category category;
    private int isDeleted;
    private int likeCnt;
    private Long userId;

    @Builder
    public Board(Long id, String title, String content, Category category, int isDeleted, int likeCnt, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.userId = userId;
        this.isDeleted = isDeleted;
        this.likeCnt = likeCnt;
    }
}

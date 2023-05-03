package com.campper.domain.boards.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Board {

    private Long id;
    private String title;
    private String content;
    private Category category;

    @Builder
    public Board(Long id, String title, String content, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
    }
}

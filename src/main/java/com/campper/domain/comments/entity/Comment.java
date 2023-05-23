package com.campper.domain.comments.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Comment {

    private Long id;
    private String content;
    private int isDeleted;
    private int likeCnt;
    private Long boardId;
    private Long userId;


    @Builder
    public Comment(Long id, String content, int isDeleted, int likeCnt, Long boardId, Long userId) {
        this.id = id;
        this.content = content;
        this.isDeleted = isDeleted;
        this.likeCnt = likeCnt;
        this.boardId = boardId;
        this.userId = userId;
    }
}

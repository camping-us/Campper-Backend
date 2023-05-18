package com.campper.domain.like.boards.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardLike {

    private Long userId;
    private Long boardId;

    @Builder BoardLike(Long userId, Long boardId) {
        this.userId = userId;
        this.boardId = boardId;
    }
}

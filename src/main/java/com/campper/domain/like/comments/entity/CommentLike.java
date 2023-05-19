package com.campper.domain.like.comments.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentLike {

    private Long userId;
    private Long commentId;

    @Builder
    CommentLike(Long userId, Long commentId) {
        this.userId = userId;
        this.commentId = commentId;
    }
}

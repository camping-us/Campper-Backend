package com.campper.domain.comments.entity;

import com.campper.global.common.entity.BaseEntity;
import com.campper.global.common.entity.TimeBaseEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment extends BaseEntity {

    private Long id;
    private String content;
    private int likeCnt;
    private Long boardId;
    private Long userId;


    @Builder
    public Comment(Long id, String content, boolean isDeleted, int likeCnt, Long boardId, Long userId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.content = content;
        this.likeCnt = likeCnt;
        this.boardId = boardId;
        this.userId = userId;
        super.setDeleted(isDeleted);
        super.setCreatedAt(createdAt);
        super.setUpdatedAt(updatedAt);
    }
}

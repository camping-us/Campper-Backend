package com.campper.domain.boards.entity;

import com.campper.global.common.entity.BaseEntity;
import com.campper.global.common.entity.TimeBaseEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Board extends BaseEntity {

    private Long id;
    private String title;
    private String content;
    private Category category;
    private int likeCnt;
    private Long userId;

    @Builder
    public Board(Long id, String title, String content, Category category, boolean isDeleted, int likeCnt, Long userId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.userId = userId;
        this.likeCnt = likeCnt;
        super.setDeleted(isDeleted);
        super.setCreatedAt(createdAt);
        super.setUpdatedAt(updatedAt);
    }
}

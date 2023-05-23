package com.campper.domain.boards.entity;

import com.campper.global.common.entity.BaseEntity;
import com.campper.global.common.entity.TimeBaseEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Image extends BaseEntity {

    private Long id;
    private String imageUrl;
    private Long boardId;

    @Builder
    public Image(Long id, String imageUrl, Long boardId, boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.boardId = boardId;
        super.setDeleted(isDeleted);
        super.setCreatedAt(createdAt);
        super.setUpdatedAt(updatedAt);
    }
}

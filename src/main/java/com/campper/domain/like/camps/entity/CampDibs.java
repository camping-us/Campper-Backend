package com.campper.domain.like.camps.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CampDibs {

    private Long userId;
    private Long campId;

    @Builder
    CampDibs(Long userId, Long campId) {
        this.userId = userId;
        this.campId = campId;
    }
}

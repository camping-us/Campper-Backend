package com.campper.global.common.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TimeBaseEntity {
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

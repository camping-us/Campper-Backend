package com.campper.global.common.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimeBaseEntity {
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}

package com.campper.global.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * soft delete 수행을 위한 클래스입니다.
 */
@Getter
@Setter
public class BaseEntity extends TimeBaseEntity{

    private boolean isDeleted;

    public void updateIsDeleted() {
        this.isDeleted = !this.isDeleted;
    }
}
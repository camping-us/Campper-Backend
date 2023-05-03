package com.campper.domain.boards.entity;

import lombok.Getter;

@Getter
public enum Category {

    FREE_BOARD("자유게시판"),
    CAMP_BOARD("캠핑게시판");

    private String name;

    Category(String name) {
        this.name = name;
    }
}

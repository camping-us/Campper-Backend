package com.campper.domain.boards.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum Category {

    FREE_BOARD("자유게시판"),
    CAMP_BOARD("캠핑게시판");

    private String name;

    Category(String name) {
        this.name = name;
    }

    @JsonCreator
    public static Category fromDto(String name) {
        for (Category category : Category.values()) {
            if (category.getName().equals(name))
                return category;
        }
        return null;
    }
}

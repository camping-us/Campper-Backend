package com.campper.domain.boards.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Image {

    private Long id;
    private String imageUrl;

    @Builder
    public Image(Long id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }
}

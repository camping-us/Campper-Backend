package com.campper.domain.camps.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Camp {
    private Long id;
    private String lineIntro;
    private String homePage;

    @Builder
    public Camp(Long id, String lineIntro, String homePage) {
        this.id = id;
        this.lineIntro = lineIntro;
        this.homePage = homePage;
    }
}

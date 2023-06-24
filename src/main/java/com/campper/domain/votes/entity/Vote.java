package com.campper.domain.votes.entity;

import com.campper.global.common.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Vote extends BaseEntity {
    private Long id;
    private Long userId;
    private Long campId;

    private int total;
    private int location;
    private int cleanliness;
    private int kindness;
    private int price;
    private int facilities;

    @Builder
    public Vote(Long id, Long userId, Long campId, int total, int location, int cleanliness, int kindness, int price, int facilities) {
        this.id = id;
        this.userId = userId;
        this.campId = campId;
        this.total = total;
        this.location = location;
        this.cleanliness = cleanliness;
        this.kindness = kindness;
        this.price = price;
        this.facilities = facilities;
    }

    public void update(int total, int location, int cleanliness, int kindness, int price, int facilities){
        this.total = total;
        this.location = location;
        this.cleanliness = cleanliness;
        this.kindness = kindness;
        this.price = price;
        this.facilities = facilities;
    }
}

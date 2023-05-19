package com.campper.domain.camps.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class VoteCamp {
    private Long campId;

    private Long total;
    private Long location;
    private Long cleanliness;
    private Long kindness;
    private Long price;
    private Long facilities;

    private Long voteCnt;

    @Builder
    public VoteCamp(Long campId, Long total, Long location, Long cleanliness, Long kindness, Long price, Long facilities, Long voteCnt) {
        this.campId = campId;
        this.total = total;
        this.location = location;
        this.cleanliness = cleanliness;
        this.kindness = kindness;
        this.price = price;
        this.facilities = facilities;
        this.voteCnt = voteCnt;
    }
}

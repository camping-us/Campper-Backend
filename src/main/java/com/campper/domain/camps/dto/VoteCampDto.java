package com.campper.domain.camps.dto;

import com.campper.domain.camps.entity.VoteCamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteCampDto {
    private Long total;
    private Long location;
    private Long cleanliness;
    private Long kindness;
    private Long price;
    private Long facilities;
    private Long voteCnt;

    @Builder
    public VoteCampDto(Long total, Long location, Long cleanliness, Long kindness, Long price, Long facilities, Long voteCnt) {
        this.total = total;
        this.location = location;
        this.cleanliness = cleanliness;
        this.kindness = kindness;
        this.price = price;
        this.facilities = facilities;
        this.voteCnt = voteCnt;
    }

    public static VoteCampDto fromEntity(VoteCamp voteCamp) {
        return VoteCampDto.builder()
                .total(voteCamp.getTotal())
                .location(voteCamp.getLocation())
                .cleanliness(voteCamp.getCleanliness())
                .kindness(voteCamp.getKindness())
                .price(voteCamp.getPrice())
                .facilities(voteCamp.getFacilities())
                .voteCnt(voteCamp.getVoteCnt())
                .build();
    }
}

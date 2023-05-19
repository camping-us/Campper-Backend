package com.campper.domain.camps.dto;

import com.campper.domain.camps.entity.VoteCamp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteCampDto {
    @ApiModelProperty(notes = "전체 평점 총합", required = true)
    private Long total;
    @ApiModelProperty(notes = "접근성 총합", required = true)
    private Long location;
    @ApiModelProperty(notes = "청결도 총합", required = true)
    private Long cleanliness;
    @ApiModelProperty(notes = "친절도 총합", required = true)
    private Long kindness;
    @ApiModelProperty(notes = "가격 적합도 총합", required = true)
    private Long price;
    @ApiModelProperty(notes = "부대 시설 총합", required = true)
    private Long facilities;
    @ApiModelProperty(notes = "투표수", required = true)
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

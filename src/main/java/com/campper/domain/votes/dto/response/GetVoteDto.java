package com.campper.domain.votes.dto.response;

import com.campper.domain.votes.entity.Vote;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetVoteDto {
    @ApiModelProperty(notes = "투표 id", required = true)
    private Long id;
    @ApiModelProperty(notes = "전체 평점", required = true)
    private int total;
    @ApiModelProperty(notes = "접근성 ", required = true)
    private int location;
    @ApiModelProperty(notes = "청결도", required = true)
    private int cleanliness;
    @ApiModelProperty(notes = "친절도", required = true)
    private int kindness;
    @ApiModelProperty(notes = "가격 적합도", required = true)
    private int price;
    @ApiModelProperty(notes = "부대 시설", required = true)
    private int facilities;

    @Builder
    public GetVoteDto(Long id, int total, int location, int cleanliness, int kindness, int price, int facilities) {
        this.id = id;
        this.total = total;
        this.location = location;
        this.cleanliness = cleanliness;
        this.kindness = kindness;
        this.price = price;
        this.facilities = facilities;
    }

    public static GetVoteDto fromEntity(Vote vote){
        return GetVoteDto.builder()
                .id(vote.getId())
                .total(vote.getTotal())
                .location(vote.getLocation())
                .cleanliness(vote.getCleanliness())
                .kindness(vote.getKindness())
                .price(vote.getPrice())
                .facilities(vote.getFacilities())
                .build();
    }
}

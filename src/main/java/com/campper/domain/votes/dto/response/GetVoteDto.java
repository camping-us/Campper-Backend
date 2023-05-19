package com.campper.domain.votes.dto.response;

import com.campper.domain.votes.entity.Vote;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetVoteDto {
    private Long id;
    private int total;
    private int location;
    private int cleanliness;
    private int kindness;
    private int price;
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

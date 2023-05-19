package com.campper.domain.camps.dto.response;

import com.campper.domain.camps.dto.CampDto;
import com.campper.domain.camps.dto.VoteCampDto;
import com.campper.domain.camps.entity.Camp;
import com.campper.domain.camps.entity.VoteCamp;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCampDto {
    @JsonUnwrapped
    private CampDto campDto;
    @JsonUnwrapped
    private VoteCampDto voteCampDto;

    @Builder
    public GetCampDto(CampDto campDto, VoteCampDto voteCampDto) {
        this.campDto = campDto;
        this.voteCampDto = voteCampDto;
    }

    public static GetCampDto fromEntity(Camp camp, VoteCamp voteCamp) {
        return GetCampDto.builder()
                .campDto(CampDto.fromEntity(camp))
                .voteCampDto(VoteCampDto.fromEntity(voteCamp))
                .build();
    }
}

package com.campper.domain.camps.dto;

import com.campper.domain.camps.entity.Camp;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class FeignCampDto {

    @JsonProperty("lineIntro")
    private String lineIntro;

    @JsonProperty("homepage")
    private String homepage;

    public static Camp toEntity(FeignCampDto feignCampDto){
        return Camp.builder()
                .lineIntro(feignCampDto.getLineIntro())
                .homePage(feignCampDto.getHomepage())
                .build();
    }
}

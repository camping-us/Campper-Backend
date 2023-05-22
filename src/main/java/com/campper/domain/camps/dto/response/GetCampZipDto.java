package com.campper.domain.camps.dto.response;

import com.campper.domain.camps.entity.CampZip;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCampZipDto {
    @ApiModelProperty(notes = "캠핑장 id", required = true)
    private Long id;
    @ApiModelProperty(notes = "캠핑장 이름", required = true)
    private String facltNm;
    @ApiModelProperty(notes = "캠핑장 한줄 소개", required = true)
    private String lineIntro;
    @ApiModelProperty(notes = "캠핑장 위도", required = true)
    private String mapX;
    @ApiModelProperty(notes = "캠핑장 경도", required = true)
    private String mapY;
    @ApiModelProperty(notes = "캠핑장 주소", required = true)
    private String addr1;
    @ApiModelProperty(notes = "캠핑장 상세 주소", required = true)
    private String addr2;

    @ApiModelProperty(notes = "전체 평점 총합", required = true)
    private Long total;
    @ApiModelProperty(notes = "투표수", required = true)
    private Long voteCnt;

    @Builder
    public GetCampZipDto(Long id, String facltNm, String lineIntro, String mapX, String mapY, String addr1, String addr2, Long total, Long voteCnt) {
        this.id = id;
        this.facltNm = facltNm;
        this.lineIntro = lineIntro;
        this.mapX = mapX;
        this.mapY = mapY;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.total = total;
        this.voteCnt = voteCnt;
    }

    public static GetCampZipDto fromEntity(CampZip campZip){
        return GetCampZipDto.builder()
                .id(campZip.getId())
                .facltNm(campZip.getFacltNm())
                .lineIntro(campZip.getLineIntro())
                .mapX(campZip.getMapX())
                .mapY(campZip.getMapY())
                .addr1(campZip.getAddr1())
                .addr2(campZip.getAddr2())
                .total(campZip.getTotal())
                .voteCnt(campZip.getVoteCnt())
                .build();
    }
}

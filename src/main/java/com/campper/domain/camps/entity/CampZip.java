package com.campper.domain.camps.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CampZip {
    private Long id;
    private String facltNm;
    private String lineIntro;
    private String mapX;
    private String mapY;
    private String addr1;
    private String addr2;

    private Long total;
    private Long voteCnt;

    @Builder
    public CampZip(Long id, String facltNm, String lineIntro, String mapX, String mapY, String addr1, String addr2, Long total, Long voteCnt) {
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
}

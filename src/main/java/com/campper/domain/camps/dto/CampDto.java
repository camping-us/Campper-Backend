package com.campper.domain.camps.dto;

import com.campper.domain.camps.entity.Camp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CampDto {
    private Long id;
    private String facltNm;
    private String lineIntro;
    private String firstImageUrl;
    private String doNm;
    private String sigunguNm;
    private String mapX;
    private String mapY;
    private String resveCl;
    private String tel;
    private String homepage;
    private String resveUrl;
    private String allar;
    private String animalCmgCl;
    private String toiletCo;
    private String swrmCo;
    private String addr1;
    private String addr2;
    private String glampInnerFclty;
    private String caravInnerFclty;
    private Long dibCnt;

    @Builder
    public CampDto(Long id, String facltNm, String lineIntro, String firstImageUrl, String doNm, String sigunguNm, String mapX, String mapY, String resveCl, String tel, String homepage, String resveUrl, String allar, String animalCmgCl, String toiletCo, String swrmCo, String addr1, String addr2, String glampInnerFclty, String caravInnerFclty, Long dibCnt) {
        this.id = id;
        this.facltNm = facltNm;
        this.lineIntro = lineIntro;
        this.firstImageUrl = firstImageUrl;
        this.doNm = doNm;
        this.sigunguNm = sigunguNm;
        this.mapX = mapX;
        this.mapY = mapY;
        this.resveCl = resveCl;
        this.tel = tel;
        this.homepage = homepage;
        this.resveUrl = resveUrl;
        this.allar = allar;
        this.animalCmgCl = animalCmgCl;
        this.toiletCo = toiletCo;
        this.swrmCo = swrmCo;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.glampInnerFclty = glampInnerFclty;
        this.caravInnerFclty = caravInnerFclty;
        this.dibCnt = dibCnt;
    }

    public static CampDto fromEntity(Camp camp) {
        return CampDto.builder()
                .id(camp.getId())
                .facltNm(camp.getFacltNm())
                .lineIntro(camp.getLineIntro())
                .firstImageUrl(camp.getFirstImageUrl())
                .doNm(camp.getDoNm())
                .sigunguNm(camp.getSigunguNm())
                .mapX(camp.getMapX())
                .mapY(camp.getMapY())
                .resveCl(camp.getResveCl())
                .tel(camp.getTel())
                .homepage(camp.getHomepage())
                .resveUrl(camp.getResveUrl())
                .allar(camp.getAllar())
                .animalCmgCl(camp.getAnimalCmgCl())
                .toiletCo(camp.getToiletCo())
                .swrmCo(camp.getSwrmCo())
                .addr1(camp.getAddr1())
                .addr2(camp.getAddr2())
                .glampInnerFclty(camp.getGlampInnerFclty())
                .caravInnerFclty(camp.getCaravInnerFclty())
                .build();
    }
}

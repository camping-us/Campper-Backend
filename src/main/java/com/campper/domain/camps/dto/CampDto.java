package com.campper.domain.camps.dto;

import com.campper.domain.camps.entity.Camp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CampDto {
    @ApiModelProperty(notes = "캠핑장 id", required = true)
    private Long id;
    @ApiModelProperty(notes = "캠핑장 이름", required = true)
    private String facltNm;
    @ApiModelProperty(notes = "캠핑장 한줄 소개", required = true)
    private String lineIntro;
    @ApiModelProperty(notes = "캠핑장 사진 주소", required = true)
    private String firstImageUrl;
    @ApiModelProperty(notes = "캠핑장 도", required = true)
    private String doNm;
    @ApiModelProperty(notes = "캠핑장 시", required = true)
    private String sigunguNm;
    @ApiModelProperty(notes = "캠핑장 위도", required = true)
    private String mapX;
    @ApiModelProperty(notes = "캠핑장 경도", required = true)
    private String mapY;
    @ApiModelProperty(notes = "캠핑장 예약 방식", required = true)
    private String resveCl;
    @ApiModelProperty(notes = "캠핑장 전화번호", required = true)
    private String tel;
    @ApiModelProperty(notes = "캠핑장 홈페이지 주소", required = true)
    private String homepage;
    @ApiModelProperty(notes = "캠핑장 예약 주소", required = true)
    private String resveUrl;
    @ApiModelProperty(notes = "캠핑장 전체 면적", required = true)
    private String allar;
    @ApiModelProperty(notes = "캠핑장 동물 여부", required = true)
    private String animalCmgCl;
    @ApiModelProperty(notes = "캠핑장 화장실 개수", required = true)
    private String toiletCo;
    @ApiModelProperty(notes = "캠핑장 샤워장 개수", required = true)
    private String swrmCo;
    @ApiModelProperty(notes = "캠핑장 주소", required = true)
    private String addr1;
    @ApiModelProperty(notes = "캠핑장 상세 주소", required = true)
    private String addr2;
    @ApiModelProperty(notes = "캠핑장 글램핑 부대시설", required = true)
    private String glampInnerFclty;
    @ApiModelProperty(notes = "캠핑장 카라반 부대시설", required = true)
    private String caravInnerFclty;
    @ApiModelProperty(notes = "캠핑장 좋아요 개수", required = true)
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
                .dibCnt(camp.getDibCnt())
                .build();
    }
}

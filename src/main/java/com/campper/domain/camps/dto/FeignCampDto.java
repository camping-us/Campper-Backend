package com.campper.domain.camps.dto;

import com.campper.domain.camps.entity.Camp;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FeignCampDto {
    @JsonProperty("response")
    private Response response;

    @Data
    public static class Response {
        @JsonProperty("body")
        private Body body;

        @Data
        public static class Body {
            @JsonProperty("items")
            private Items items;

            @Data
            public static class Items {
                private final List<Item> list;

                @JsonCreator
                public Items(@JsonProperty("item") List<Item> list) {
                    this.list = list;
                }

                @Data
                public static class Item {
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

                }
            }
        }
    }


    public static Camp toEntity(Response.Body.Items.Item item) {
        return Camp.builder()
                .facltNm(item.getFacltNm())
                .lineIntro(item.getLineIntro())
                .firstImageUrl(item.getFirstImageUrl())
                .doNm(item.getDoNm())
                .sigunguNm(item.getSigunguNm())
                .mapX(item.getMapX())
                .mapY(item.getMapY())
                .resveCl(item.getResveCl())
                .tel(item.getTel())
                .homepage(item.getHomepage())
                .resveUrl(item.getResveUrl())
                .allar(item.getAllar())
                .animalCmgCl(item.getAnimalCmgCl())
                .toiletCo(item.getToiletCo())
                .swrmCo(item.getSwrmCo())
                .addr1(item.getAddr1())
                .addr2(item.getAddr2())
                .glampInnerFclty(item.getGlampInnerFclty())
                .caravInnerFclty(item.getCaravInnerFclty())
                .build();
    }

}

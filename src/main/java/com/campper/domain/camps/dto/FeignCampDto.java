package com.campper.domain.camps.dto;

import com.campper.domain.camps.entity.Camp;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class FeignCampDto {

//    @JsonProperty("response")
//    private Map<String, Map<String, Object>> response;
//
////    @JsonProperty("response/body/items")
//    private Items items = (Items) response.get("body").get("items");
//
//    @Data
//    public static class Items {
//        @JsonProperty("item")
//        private final List<Item> list;
//
//        @JsonCreator
//        public Items(List<Item> list) {
//            this.list = list;
//        }
//
//        @Data
//        public static class Item {
//            @JsonProperty("lineIntro")
//            private String lineIntro;
//
//            @JsonProperty("homepage")
//            private String homepage;
//        }
//    }

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
                @JsonProperty("item")
                private final List<Item> list;

                @JsonCreator
                public Items(List<Item> list) {
                    this.list = list;
                }

                @Data
                public static class Item {
                    @JsonProperty("lineIntro")
                    private String lineIntro;

                    @JsonProperty("homepage")
                    private String homepage;
                }
            }
        }
    }

    public static Camp toEntity(FeignCampDto feignCampDto) {
        return Camp.builder()
//                .lineIntro(feignCampDto.getItems().getItem().getLineIntro())
//                .homePage(feignCampDto.getItems().getItem().getLineIntro())
                .build();
    }

}

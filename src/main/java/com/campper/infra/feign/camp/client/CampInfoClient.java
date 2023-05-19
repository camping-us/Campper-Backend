package com.campper.infra.feign.camp.client;

import com.campper.infra.feign.camp.dto.CampDto;
import com.campper.global.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url = "https://apis.data.go.kr/B551011/GoCamping",
        name = "campInfo",
        configuration = FeignConfig.class)
public interface CampInfoClient {
    @GetMapping(value = "/basedList", produces = "application/json", consumes = "application/json")
    CampDto callOpenApi(
            @RequestParam("serviceKey") String serviceKey,
            @RequestParam("numOfRows") Long rows,
            @RequestParam("pageNo") Long pageNo,
            @RequestParam("MobileOS") String mobileOs,
            @RequestParam("MobileApp") String mobileApp,
            @RequestParam("_type") String type
    );
}

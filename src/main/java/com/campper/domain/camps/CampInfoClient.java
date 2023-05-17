package com.campper.domain.camps;

import com.campper.domain.camps.dto.FeignCampDto;
import com.campper.global.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url = "https://apis.data.go.kr/B551011/GoCamping",
        name = "campInfo",
        configuration = FeignConfig.class)
public interface CampInfoClient {
    @GetMapping(value = "/basedList", produces = "application/json", consumes = "application/json")
    FeignCampDto callOpenApi(
            @RequestParam("serviceKey") String serviceKey,
            @RequestParam("numOfRows") Long rows,
            @RequestParam("pageNo") Long pageNo,
            @RequestParam("MobileOS") String mobileOs,
            @RequestParam("MobileApp") String mobileApp,
            @RequestParam("_type") String type
    );
}

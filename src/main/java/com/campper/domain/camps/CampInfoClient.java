package com.campper.domain.camps;

import com.campper.domain.camps.dto.FeignCampDto;
import com.campper.global.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "https://apis.data.go.kr/B551011/GoCamping", name = "campInfo", configuration = FeignConfig.class)
public interface CampInfoClient {
    @GetMapping(value = "/basedList",  produces = "application/json", consumes = "application/json")
    List<FeignCampDto> callOpenApi(
            @RequestParam("numOfRows") Long rows,
            @RequestParam("MobileOS") String mobileOs,
            @RequestParam("MobileApp") String mobileApp,
            @RequestParam("serviceKey") String serviceKey,
            @RequestParam("_type") String contentType
    );
}

package com.campper.domain.camps;

import com.campper.domain.camps.service.CampService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/place")
@Api(tags = "캠핑장")
public class CampController {
    private final CampService campService;

    @PostMapping("/")
    @Operation(summary = "공공 API 데이터 DB 추가 요청", description = "공공 API 데이터 DB 추가 요청, 관리자만 실행 가능합니다.")
    public void postOpenApi(){
        campService.loadOpenApi();
    }
}

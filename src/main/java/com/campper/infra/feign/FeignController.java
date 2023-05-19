package com.campper.infra.feign;

import com.campper.domain.users.entity.User;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/infra")
@Api(tags = "인프라")
public class FeignController {
    private final FeignService feignService;
    @GetMapping("/camp-open-api")
    @Operation(summary = "공공 API 데이터 DB 추가 요청", description = "공공 API 데이터 DB 추가 요청, 관리자만 실행 가능합니다.")
    public void postOpenApi(@AuthenticationPrincipal User user){
        feignService.loadOpenApi(user);
    }
}

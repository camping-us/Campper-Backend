package com.campper.domain.like.camps;

import com.campper.domain.like.camps.service.CampDibsService;
import com.campper.domain.users.entity.User;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/camp-dibs")
@Api(tags = "캠프 찜")
public class CampDibsController {

    private final CampDibsService campDibsService;

    @PostMapping("/{id}")
    @Operation(summary = "캠핑장 찜", description = "캠핑장 찜 누르는 요청 API 입니다. 이미 누른 경우에는 좋아요 취소가 됩니다.")
    public void postCampDibs(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        campDibsService.dibs(id, user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "캠핑장 찜 여부 확인", description = "캠핑장 찜 여부 요청 API 입니다. 이미 누른 경우에는 true 가 반환됩니다.")
    public Boolean getIsCampDibs(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return campDibsService.checkDibs(id, user);
    }
}

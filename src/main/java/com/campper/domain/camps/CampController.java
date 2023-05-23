package com.campper.domain.camps;

import com.campper.domain.camps.dto.response.GetCampDto;
import com.campper.domain.camps.dto.response.GetCampZipDto;
import com.campper.domain.camps.service.CampService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/places")
@Api(tags = "캠핑장")
public class CampController {
    private final CampService campService;
    @GetMapping("/{id}")
    @Operation(summary = "캠핑장 정보 요청", description = "캠핑장 정보 요청 API 입니다.")
    public GetCampDto getPlace(@PathVariable("id") Long id){
        return campService.getCamp(id);
    }

    @GetMapping("")
    @Operation(summary = "캠핑장 리스트 요청", description = "캠핑장 리스트 요청 API 입니다.")
    public List<GetCampZipDto> getPlaces(){
        return campService.getCamps();
    }

}

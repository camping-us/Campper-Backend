package com.campper.domain.camps;

import com.campper.domain.camps.dto.response.GetCampDto;
import com.campper.domain.camps.service.CampService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/place")
@Api(tags = "캠핑장")
public class CampController {
    private final CampService campService;
    @GetMapping("/{id}")
    public GetCampDto getPlace(@PathVariable("id") Long id){
        return campService.getCamp(id);
    }

}

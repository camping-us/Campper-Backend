package com.campper.domain.camps.service;

import com.campper.domain.camps.dto.response.GetCampDto;
import com.campper.domain.camps.dto.response.GetCampZipDto;

import java.util.List;

public interface CampService {

    GetCampDto getCamp(Long id);

    List<GetCampZipDto> getCamps();
}

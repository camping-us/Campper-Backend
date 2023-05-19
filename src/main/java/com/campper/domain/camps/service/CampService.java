package com.campper.domain.camps.service;

import com.campper.domain.camps.dto.response.GetCampDto;

public interface CampService {

    GetCampDto getCamp(Long id);
}

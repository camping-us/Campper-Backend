package com.campper.domain.camps.service;

import com.campper.domain.camps.CampInfoClient;
import com.campper.domain.camps.dto.FeignCampDto;
import com.campper.domain.camps.entity.Camp;
import com.campper.domain.camps.mapper.CampInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CampServiceImpl implements CampService {
    private final CampInfoClient campInfoClient;
    private final CampInterface campInterface;

    private static final String mobileOs = "ETC";
    @Value("${SERVICE_NAME}")
    private String serviceName;
    @Value("${SERVICE_KEY}")
    private String serviceKey;

    @Override
    @Transactional
    public void loadOpenApi() {
        FeignCampDto feignCampDto = campInfoClient.callOpenApi(serviceKey, 1L, 1L, mobileOs, serviceName, "json");
        log.info(String.valueOf(feignCampDto));
    }
}

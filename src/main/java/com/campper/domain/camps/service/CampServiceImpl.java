package com.campper.domain.camps.service;

import com.campper.domain.camps.dto.response.GetCampDto;
import com.campper.domain.camps.dto.response.GetCampZipDto;
import com.campper.domain.camps.entity.Camp;
import com.campper.domain.camps.entity.CampZip;
import com.campper.domain.camps.entity.VoteCamp;
import com.campper.domain.camps.repository.CampRepository;
import com.campper.domain.camps.repository.CampZipRepository;
import com.campper.domain.camps.repository.VoteCampRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CampServiceImpl implements CampService {
    private final CampRepository campRepository;
    private final VoteCampRepository voteCampRepository;
    private final CampZipRepository campZipRepository;

    @Override
    public GetCampDto getCamp(Long id) {
        Camp camp = campRepository.findById(id);
        VoteCamp voteCamp = voteCampRepository.findByCampId(id);

        return GetCampDto.fromEntity(camp,voteCamp);
    }

    @Override
    public List<GetCampZipDto> getCamps() {
        List<GetCampZipDto> camps = new ArrayList<>();
        for (CampZip campZip : campZipRepository.findAll()) {
            camps.add(GetCampZipDto.fromEntity(campZip));
        }
        return camps;
    }
}

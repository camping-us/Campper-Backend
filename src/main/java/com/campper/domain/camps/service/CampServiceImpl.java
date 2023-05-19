package com.campper.domain.camps.service;

import com.campper.domain.camps.dto.response.GetCampDto;
import com.campper.domain.camps.entity.Camp;
import com.campper.domain.camps.entity.VoteCamp;
import com.campper.domain.camps.mapper.CampInterface;
import com.campper.domain.camps.mapper.VoteCampRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CampServiceImpl implements CampService {
    private final CampInterface campInterface;
    private final VoteCampRepository voteCampRepository;

    @Override
    public GetCampDto getCamp(Long id) {
        Camp camp = campInterface.findById(id);
        VoteCamp voteCamp = voteCampRepository.findByCampId(id);

        return GetCampDto.fromEntity(camp,voteCamp);
    }
}

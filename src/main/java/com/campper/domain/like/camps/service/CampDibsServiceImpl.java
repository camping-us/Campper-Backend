package com.campper.domain.like.camps.service;

import com.campper.domain.camps.repository.CampRepository;
import com.campper.domain.like.camps.entity.CampDibs;
import com.campper.domain.like.camps.repository.CampDibsRepository;
import com.campper.domain.users.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CampDibsServiceImpl implements CampDibsService {

    private final CampDibsRepository campDibsRepository;
    private final CampRepository campRepository;

    @Override
    public void dibs(Long id, User user) {
        CampDibs campDibs = CampDibs.builder()
                .userId(user.getId())
                .campId(id)
                .build();

        if (campDibsRepository.existByCampIdAndUserId(campDibs)) {
            campDibsRepository.dibsCancel(campDibs);
            campRepository.decreaseDibsCnt(id);
        } else {
            campDibsRepository.dibs(campDibs);
            campRepository.increaseDibsCnt(id);
        }
    }

    @Override
    public boolean checkDibs(Long id, User user) {
        CampDibs campDibs = CampDibs.builder()
                .userId(user.getId())
                .campId(id)
                .build();

        return campDibsRepository.existByCampIdAndUserId(campDibs);
    }
}

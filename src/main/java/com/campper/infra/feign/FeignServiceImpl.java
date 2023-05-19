package com.campper.infra.feign;

import com.campper.domain.camps.entity.Camp;
import com.campper.domain.camps.mapper.CampInterface;
import com.campper.domain.camps.mapper.VoteCampRepository;
import com.campper.domain.users.entity.Role;
import com.campper.domain.users.entity.User;
import com.campper.global.common.error.ErrorCode;
import com.campper.global.common.error.exception.UnauthorizedException;
import com.campper.infra.feign.camp.client.CampInfoClient;
import com.campper.infra.feign.camp.dto.CampDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FeignServiceImpl implements FeignService{
    private final CampInfoClient campInfoClient;
    private final CampInterface campInterface;
    private final VoteCampRepository voteCampRepository;

    private static final String mobileOs = "ETC";
    @Value("${SERVICE_NAME}")
    private String serviceName;
    @Value("${SERVICE_KEY}")
    private String serviceKey;

    @Override
    @Transactional
    public void loadOpenApi(User user) {
        if(user.getRole() != Role.ROLE_ADMIN){
            throw new UnauthorizedException(ErrorCode.USER_NOT_ADMIN);
        }

        CampDto campDto = campInfoClient.callOpenApi(serviceKey, 3467L, 1L, mobileOs, serviceName, "json");
        log.info(String.valueOf(campDto));

        ArrayList<Camp> camps = new ArrayList<>();
        for (CampDto.Response.Body.Items.Item item : campDto.getResponse().getBody().getItems().getList()) {
            Camp camp = CampDto.toEntity(item);
            camps.add(camp);
        }
        log.info(""+camps.size());
        campInterface.saveList(camps);

        voteCampRepository.saves(IntStream.iterate(1, i -> i + 1)
                .limit(camps.size())
                .boxed()
                .collect(Collectors.toList()));
    }
}

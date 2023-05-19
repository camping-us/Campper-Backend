package com.campper.domain.camps.mapper;

import com.campper.domain.camps.entity.VoteCamp;
import com.campper.domain.votes.entity.Vote;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VoteCampInterface {
    VoteCamp findByCampId(Long campId);

    void update(Vote vote);

    void saves(int size);
}

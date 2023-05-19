package com.campper.domain.camps.mapper;

import com.campper.domain.camps.entity.VoteCamp;
import com.campper.domain.votes.entity.Vote;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VoteCampRepository {
    VoteCamp findByCampId(Long campId);

    void updateIncrease(Vote vote);

    void updateDecrease(Vote vote);

    void saves(List<Integer> list);
}

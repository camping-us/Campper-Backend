package com.campper.domain.votes.repository;

import com.campper.domain.votes.dto.VoteInfo;
import com.campper.domain.votes.entity.Vote;
import com.campper.domain.votes.service.VoteServiceImpl;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VoteRepository {
    void save(Vote vote);

    void update(Vote vote);

    Vote findByCampIdAndUserId(VoteInfo voteInfo);

    Vote findById(Long id);
}
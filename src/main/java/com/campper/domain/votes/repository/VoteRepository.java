package com.campper.domain.votes.repository;

import com.campper.domain.votes.dto.VoteInfo;
import com.campper.domain.votes.entity.Vote;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VoteRepository {
    void save(Vote vote);

    void update(Vote vote);

    void delete(Vote vote);

    boolean existByCampIdAndUserId(VoteInfo voteInfo);

    Vote findByCampIdAndUserId(VoteInfo voteInfo);

    Vote findById(Long id);
}

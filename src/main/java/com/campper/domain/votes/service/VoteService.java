package com.campper.domain.votes.service;

import com.campper.domain.users.entity.User;
import com.campper.domain.votes.dto.request.PostVoteDto;
import com.campper.domain.votes.dto.response.GetVoteDto;

public interface VoteService {
    void saveVote(Long campId, PostVoteDto postVoteDto, User user);

    Boolean checkVote(Long campId, User user);

    GetVoteDto getVote(Long campId, User user);

    void delVote(Long id, User user);
}

package com.campper.domain.votes.service;

import com.campper.domain.camps.repository.VoteCampRepository;
import com.campper.domain.users.entity.User;
import com.campper.domain.votes.dto.VoteInfo;
import com.campper.domain.votes.dto.request.PostVoteDto;
import com.campper.domain.votes.dto.response.GetVoteDto;
import com.campper.domain.votes.entity.Vote;
import com.campper.domain.votes.repository.VoteRepository;
import com.campper.global.common.error.ErrorCode;
import com.campper.global.common.error.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;
    private final VoteCampRepository voteCampRepository;

    @Override
    public void saveVote(Long campId, PostVoteDto postVoteDto, User user) {
        Vote vote = Vote.builder()
                .userId(user.getId())
                .campId(campId)
                .total(postVoteDto.getTotal())
                .location(postVoteDto.getLocation())
                .price(postVoteDto.getPrice())
                .cleanliness(postVoteDto.getCleanliness())
                .kindness(postVoteDto.getKindness())
                .facilities(postVoteDto.getFacilities())
                .build();
        voteRepository.save(vote);
        voteCampRepository.updateIncrease(vote);
    }

    @Override
    public GetVoteDto getVote(Long campId, User user) {
        VoteInfo voteInfo = new VoteInfo(campId, user.getId());
        Vote vote = voteRepository.findByCampIdAndUserId(voteInfo);
        if (vote == null)
            return null;
        return GetVoteDto.fromEntity(vote);
    }

    @Override
    public void delVote(Long id, User user) {
        Vote vote = voteRepository.findById(id);
        if (vote.getUserId() != user.getId()) {
            throw new UnauthorizedException(ErrorCode.UNAUTHORIZED_ACCESS);
        }
        vote.updateIsDeleted();
        voteRepository.update(vote);
        voteCampRepository.updateDecrease(vote);
    }
}

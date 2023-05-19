package com.campper.domain.votes.dto;

public class VoteInfo {
    private Long campId;
    private Long userId;

    public VoteInfo(Long campId, Long userId) {
        this.campId = campId;
        this.userId = userId;
    }
}

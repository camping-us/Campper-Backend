package com.campper.domain.like.boards.service;

import com.campper.domain.boards.repository.BoardRepository;
import com.campper.domain.like.boards.entity.BoardLike;
import com.campper.domain.like.boards.repository.BoardLikeRepository;
import com.campper.domain.users.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardLikeServiceImpl implements BoardLikeService{

    private final BoardLikeRepository boardLikeRepository;
    private final BoardRepository boardRepository;

    @Override
    public void like(Long id, User user) {
        BoardLike boardLike = BoardLike.builder()
                .userId(user.getId())
                .boardId(id)
                .build();
        log.info("boardlike:" + boardLike.getBoardId());

        if (boardLikeRepository.existByBoardIdAndUserId(boardLike)) {
            boardLikeRepository.likeCancel(boardLike);
            boardRepository.decreaseLikeCnt(id);
        }
        else {
            boardLikeRepository.like(boardLike);
            boardRepository.increaseLikeCnt(id);
        }
    }
}

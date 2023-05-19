package com.campper.domain.like.comments.service;

import com.campper.domain.comments.repository.CommentRepository;
import com.campper.domain.like.comments.entity.CommentLike;
import com.campper.domain.like.comments.repository.CommentLikeRepository;
import com.campper.domain.users.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentLikeServiceImpl implements CommentLikeService{

    private final CommentLikeRepository commentLikeRepository;
    private final CommentRepository commentRepository;

    @Override
    public void like(Long id, User user) {
        CommentLike commentLike = CommentLike.builder()
                .userId(user.getId())
                .commentId(id)
                .build();
        log.info("SS" + commentLikeRepository.existByCommentIdAndUserId(commentLike));
        if (commentLikeRepository.existByCommentIdAndUserId(commentLike)) {
            commentLikeRepository.likeCancel(commentLike);
            commentRepository.decreaseLikeCnt(id);
        } else {
            commentLikeRepository.like(commentLike);
            commentRepository.increaseLikeCnt(id);
        }
    }
}

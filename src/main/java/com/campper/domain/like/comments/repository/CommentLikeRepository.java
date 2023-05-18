package com.campper.domain.like.comments.repository;

import com.campper.domain.like.boards.entity.BoardLike;
import com.campper.domain.like.comments.entity.CommentLike;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentLikeRepository {

    // 유저 좋아요 있는지 확인
    boolean existByCommentIdAndUserId(CommentLike commentLike);
    // 좋아요 누르기
    Long like(CommentLike commentLike);
    // 좋아요 취소하기
    Long likeCancel(CommentLike commentLike);
}

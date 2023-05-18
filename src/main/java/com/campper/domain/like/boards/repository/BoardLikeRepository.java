package com.campper.domain.like.boards.repository;

import com.campper.domain.like.boards.entity.BoardLike;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardLikeRepository {

    // 유저 좋아요 있는지 확인
    boolean existByBoardIdAndUserId(BoardLike boardLike);
    // 좋아요 누르기
    Long like(BoardLike boardLike);
    // 좋아요 취소하기
    Long likeCancel(BoardLike boardLike);
}

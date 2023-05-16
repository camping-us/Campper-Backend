package com.campper.domain.boards.repository;

import com.campper.domain.boards.entity.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {

    // id로 글이 있는지 확인
    boolean existByBoardId(Long id);

    // 글 쓰기
    Long save(Board board);

    // 글 리스트 조회
    // TODO: 글 페이지 조회

    // 글 상세 조회
    Board findByBoardId(Long id);

    // 글 수정
    Long update(Board board);

    // 글 삭제
    void delete(Long id);
}

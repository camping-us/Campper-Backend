package com.campper.domain.boards.repository;

import com.campper.domain.boards.dto.request.BoardParameterDto;
import com.campper.domain.boards.dto.response.GetBoardDto;
import com.campper.domain.boards.entity.Board;
import com.campper.domain.boards.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {

    // id로 글이 있는지 확인
    boolean existByBoardId(Long id);

    // 글 쓰기
    Long save(Board board);

    // 글 리스트 조회
    List<Board> listBoard(BoardParameterDto boardParameterDto);

    // 글 상세 조회
    Board findByBoardId(Long id);

    // 글 수정
    Long update(Board board);

    // 글 삭제
    void delete(Long id);

    // 글 좋아요 수 증가
    void increaseLikeCnt(Long id);

    // 글 좋아요 수 감소
    void decreaseLikeCnt(Long id);

    // 글 전체 개수 확인
    int getBoardCntByCategory(Category category);
}

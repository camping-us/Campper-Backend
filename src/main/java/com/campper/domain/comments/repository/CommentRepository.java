package com.campper.domain.comments.repository;

import com.campper.domain.boards.entity.Board;
import com.campper.domain.comments.dto.request.CommentParameterDto;
import com.campper.domain.comments.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository {

    // id로 댓글이 있는지 확인
    boolean existByCommentId(Long id);

    // 댓글 쓰기
    Long save(Comment comment);

    // 댓글 리스트 조회
    List<Comment> listComment(CommentParameterDto commentParameterDto);

    // 댓글 상세 조회
    Comment findByCommentId(Long id);

    // 댓글 수정
    Long update(Comment comment);

    // 댓글 삭제
    void delete(Long id);
}

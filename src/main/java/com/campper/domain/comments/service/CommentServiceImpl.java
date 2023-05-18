package com.campper.domain.comments.service;

import com.campper.domain.comments.dto.request.CommentParameterDto;
import com.campper.domain.comments.dto.request.PatchCommentDto;
import com.campper.domain.comments.dto.request.SaveCommentDto;
import com.campper.domain.comments.dto.response.GetCommentDto;
import com.campper.domain.comments.entity.Comment;
import com.campper.domain.comments.repository.CommentRepository;
import com.campper.domain.users.entity.User;
import com.campper.domain.users.repository.UserRepository;
import com.campper.global.common.error.ErrorCode;
import com.campper.global.common.error.exception.BadRequestException;
import com.campper.global.common.error.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Override
    public GetCommentDto save(SaveCommentDto saveCommentDto, User user) {
        Comment comment = Comment.builder()
                .content(saveCommentDto.getContent())
                .userId(user.getId())
                .boardId(saveCommentDto.getBoardId())
                .build();

        commentRepository.save(comment);

        return GetCommentDto.fromEntity(comment, user.getNickName());
    }

    @Override
    public List<GetCommentDto> getCommentList(CommentParameterDto commentParameterDto) {
        List<GetCommentDto> comments = new ArrayList<>();

        int start = commentParameterDto.getPg() == 0 ? 0 : (commentParameterDto.getPg() - 1) * commentParameterDto.getSpp();
        commentParameterDto.setStart(start);
        List<Comment> commentList = commentRepository.listComment(commentParameterDto);
        log.info("commentList");
        for (Comment comment : commentList) {
            User user = userRepository.findById(comment.getUserId());
            String userName = user.getNickName();
            comments.add(GetCommentDto.fromEntity(comment, userName));
        }
        return comments;
    }

    @Override
    public GetCommentDto updateComment(Long commentId, PatchCommentDto patchCommentDto, User user) {
        // 유저id, 댓글id 유효성 검사
        commentValidate(commentId, user);

        Comment comment = Comment.builder()
                .id(commentId)
                .content(patchCommentDto.getContent())
                .build();

        commentRepository.update(comment);

        return GetCommentDto.fromEntity(comment, user.getNickName());
    }

    @Override
    public void withdraw(Long commentId, User user) {
        // 유저id, 댓글id 유효성 검사
        commentValidate(commentId, user);

        commentRepository.delete(commentId);
    }

    private void commentValidate(Long id, User user) {
        Comment existComment = commentRepository.findByCommentId(id);
        if (existComment == null)
            throw new BadRequestException(ErrorCode.COMMENT_NOT_FOUND);
        if (existComment.getUserId() != user.getId())
            throw new UnauthorizedException(ErrorCode.FORBIDDEN_USER);
    }
}

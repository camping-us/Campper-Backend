package com.campper.domain.comments.service;

import com.campper.domain.comments.dto.request.CommentParameterDto;
import com.campper.domain.comments.dto.request.PatchCommentDto;
import com.campper.domain.comments.dto.request.SaveCommentDto;
import com.campper.domain.comments.dto.response.GetCommentDto;
import com.campper.domain.users.entity.User;

import java.util.List;

public interface CommentService {

    public GetCommentDto save(SaveCommentDto saveCommentDto, User user);
    public List<GetCommentDto> getCommentList(CommentParameterDto commentParameterDto);
    public GetCommentDto updateComment(Long boardId, PatchCommentDto patchCommentDto, User user);
    public void withdraw(Long id, User user);
}

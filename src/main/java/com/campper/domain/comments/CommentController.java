package com.campper.domain.comments;

import com.campper.domain.comments.dto.request.CommentParameterDto;
import com.campper.domain.comments.dto.request.PatchCommentDto;
import com.campper.domain.comments.dto.request.SaveCommentDto;
import com.campper.domain.comments.dto.response.GetCommentDto;
import com.campper.domain.comments.service.CommentService;
import com.campper.domain.users.entity.User;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
@Api(tags = "댓글")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{boardId}")
    @Operation(summary = "댓글 생성", description = "댓글 생성 요청 API 입니다.")
    public GetCommentDto postComment(
            @PathVariable Long boardId,
            @RequestBody @Valid SaveCommentDto saveCommentDto,
            @AuthenticationPrincipal User user
    ) {
        return commentService.save(boardId, saveCommentDto, user);
    }

    @GetMapping("/{boardId}")
    @Operation(summary = "댓글 목록 조회", description = "댓글 목록 조회 API 입니다.")
    public List<GetCommentDto> getBoards(
            @PathVariable Long boardId,
            CommentParameterDto commentParameterDto
    ) {
        return commentService.getCommentList(boardId, commentParameterDto);
    }

    @PatchMapping("/")
    @Operation(summary = "댓글 수정", description = "댓글 수정 요청 API 입니다.")
    public GetCommentDto patchComment(
            @RequestParam Long commentId,
            @RequestBody @Valid PatchCommentDto patchCommentDto,
            @AuthenticationPrincipal User user
    ) {
        return commentService.updateComment(commentId, patchCommentDto, user);
    }

    @DeleteMapping("/")
    @Operation(summary = "댓글 삭제", description = "게시글 삭제 요청 API 입니다.")
    public void delComment(
            @RequestParam Long commentId,
            @AuthenticationPrincipal User user
    ) {
        commentService.withdraw(commentId, user);
    }
}

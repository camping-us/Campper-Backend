package com.campper.domain.like.comments;

import com.campper.domain.like.boards.service.BoardLikeService;
import com.campper.domain.like.comments.service.CommentLikeService;
import com.campper.domain.users.entity.User;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment-like")
@Api(tags = "댓글 좋아요")
public class CommentLikeController {

    private final CommentLikeService commentLikeService;

    @PostMapping("/{id}")
    @Operation(summary = "댓글 좋아요", description = "댓글 좋아요 누르는 요청 API 입니다. 이미 누른 경우에는 좋아요 취소가 됩니다.")
    public void postCommentLike(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        commentLikeService.like(id, user);
    }
}

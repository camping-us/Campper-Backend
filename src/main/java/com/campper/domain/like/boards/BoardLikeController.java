package com.campper.domain.like.boards;

import com.campper.domain.boards.dto.request.SaveBoardDto;
import com.campper.domain.boards.dto.response.GetBoardDetailDto;
import com.campper.domain.like.boards.service.BoardLikeService;
import com.campper.domain.users.entity.User;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/board-like")
@Api(tags = "게시글 좋아요")
public class BoardLikeController {

    private final BoardLikeService boardLikeService;

    @PostMapping("/{id}")
    @Operation(summary = "게시글 좋아요", description = "게시글 좋아요 누르는 요청 API 입니다. 이미 누른 경우에는 좋아요 취소가 됩니다.")
    public void postBoardLike(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        boardLikeService.like(id, user);
    }
}

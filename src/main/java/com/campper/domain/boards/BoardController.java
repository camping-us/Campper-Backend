package com.campper.domain.boards;

import com.campper.domain.boards.dto.request.BoardParameterDto;
import com.campper.domain.boards.dto.request.PatchBoardDto;
import com.campper.domain.boards.dto.request.SaveBoardDto;
import com.campper.domain.boards.dto.response.GetBoardDetailDto;
import com.campper.domain.boards.dto.response.GetBoardDto;
import com.campper.domain.boards.service.BoardService;
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
@RequestMapping("/boards")
@Api(tags = "게시판")
public class BoardController {

    private final BoardService boardService;
    @PostMapping("/")
    @Operation(summary = "게시글 생성", description = "게시글 생성 요청 API 입니다.")
    public GetBoardDetailDto postBoard(
            @RequestBody @Valid SaveBoardDto saveBoardDto,
            @AuthenticationPrincipal User user
            ) {
        return boardService.save(saveBoardDto, user);
    }

    @GetMapping("/")
    @Operation(summary = "게시글 목록 조회", description = "게시글 목록 조회 API 입니다.")
    public List<GetBoardDto> getBoards(
            BoardParameterDto boardParameterDto
    ) {
        return boardService.getBoardList(boardParameterDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "게시글 상세 조회", description = "게시글 상세 보기 요청 API 입니다.")
    public GetBoardDetailDto getBoardDetail(
            @PathVariable Long id
    ) {
        return boardService.getBoardById(id);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "게시글 수정", description = "게시글 수정 요청 API 입니다.")
    public GetBoardDetailDto patchBoard(
            @PathVariable Long id,
            @RequestBody @Valid PatchBoardDto patchBoardDto,
            @AuthenticationPrincipal User user
    ) {
        return boardService.updateBoard(id, patchBoardDto, user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제", description = "게시글 삭제 요청 API 입니다.")
    public void delBoard(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        boardService.withdraw(id, user);
    }
}

package com.campper.domain.boards;

import com.campper.domain.boards.dto.request.PatchBoardDto;
import com.campper.domain.boards.dto.request.SaveBoardDto;
import com.campper.domain.boards.dto.response.GetBoardDetailDto;
import com.campper.domain.boards.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
            @RequestBody @Valid SaveBoardDto saveBoardDto
    ) {
        return boardService.save(saveBoardDto);
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
            @RequestBody @Valid PatchBoardDto patchBoardDto
    ) {
        return boardService.updateBoard(id, patchBoardDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제", description = "게시글 삭제 요청 API 입니다.")
    public void delBoard(
            @PathVariable Long id
    ) {
        boardService.withdraw(id);
    }
}
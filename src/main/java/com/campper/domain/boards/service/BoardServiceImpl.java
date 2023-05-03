package com.campper.domain.boards.service;

import com.campper.domain.boards.dto.request.PatchBoardDto;
import com.campper.domain.boards.dto.request.SaveBoardDto;
import com.campper.domain.boards.dto.response.GetBoardDetailDto;
import com.campper.domain.boards.entity.Board;
import com.campper.domain.boards.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    // 임시 데이터 : images null 로 표시

    @Override
    public GetBoardDetailDto save(SaveBoardDto saveBoardDto) {
        Board board = Board.builder()
                .title(saveBoardDto.getTitle())
                .content(saveBoardDto.getContent())
                .category(saveBoardDto.getCategory())
                .build();
        boardRepository.save(board);

        return GetBoardDetailDto.fromEntity(board, null);
    }

    @Override
    public GetBoardDetailDto getBoardById(Long id) {
        Board board = boardRepository.findByBoardId(id);

        return GetBoardDetailDto.fromEntity(board, null);
    }

    @Override
    public GetBoardDetailDto updateBoard(Long id, PatchBoardDto patchBoardDto) {
        Board board = Board.builder()
                .title(patchBoardDto.getTitle())
                .content(patchBoardDto.getContent())
                .build();

        boardRepository.update(board);
        return GetBoardDetailDto.fromEntity(board, null);
    }

    @Override
    public void withdraw(Long id) {

        // TODO: soft delete 적용 필요

        boardRepository.delete(id);
    }

    private Board findBoardById(Long id) {
        // TODO: board id 존재 여부
        return null;
    }
}

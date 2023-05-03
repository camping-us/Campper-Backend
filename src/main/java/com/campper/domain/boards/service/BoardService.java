package com.campper.domain.boards.service;

import com.campper.domain.boards.dto.request.PatchBoardDto;
import com.campper.domain.boards.dto.request.SaveBoardDto;
import com.campper.domain.boards.dto.response.GetBoardDetailDto;

public interface BoardService {

    public GetBoardDetailDto save(SaveBoardDto saveBoardDto);
    public GetBoardDetailDto getBoardById(Long id);
    public GetBoardDetailDto updateBoard(Long id, PatchBoardDto patchBoardDto);
    public void withdraw(Long id);

}

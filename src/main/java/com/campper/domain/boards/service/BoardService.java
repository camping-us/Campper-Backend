package com.campper.domain.boards.service;

import com.campper.domain.boards.dto.request.BoardParameterDto;
import com.campper.domain.boards.dto.request.PatchBoardDto;
import com.campper.domain.boards.dto.request.SaveBoardDto;
import com.campper.domain.boards.dto.response.GetBoardDetailDto;
import com.campper.domain.boards.dto.response.GetBoardDto;
import com.campper.domain.boards.dto.response.GetListBoardDto;
import com.campper.domain.boards.entity.Board;
import com.campper.domain.users.entity.User;

import java.util.List;

public interface BoardService {

    public GetBoardDetailDto save(SaveBoardDto saveBoardDto, User user);
    public GetListBoardDto getBoardList(BoardParameterDto boardParameterDto);
    public GetBoardDetailDto getBoardById(Long id);
    public GetBoardDetailDto updateBoard(Long id, PatchBoardDto patchBoardDto, User user);
    public void withdraw(Long id, User user);

}

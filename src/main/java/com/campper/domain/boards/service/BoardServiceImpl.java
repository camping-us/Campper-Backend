package com.campper.domain.boards.service;

import com.campper.domain.boards.dto.request.PatchBoardDto;
import com.campper.domain.boards.dto.request.SaveBoardDto;
import com.campper.domain.boards.dto.response.GetBoardDetailDto;
import com.campper.domain.boards.entity.Board;
import com.campper.domain.boards.entity.Image;
import com.campper.domain.boards.repository.BoardRepository;
import com.campper.domain.boards.repository.ImageRepository;
import com.campper.domain.users.entity.User;
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
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;

    @Override
    public GetBoardDetailDto save(SaveBoardDto saveBoardDto, User user) {
        Board board = Board.builder()
                .title(saveBoardDto.getTitle())
                .content(saveBoardDto.getContent())
                .category(saveBoardDto.getCategory())
                .userId(user.getId())
                .build();

        boardRepository.save(board);

        for (String imageUrl : saveBoardDto.getImages()) {
            Image image = Image.builder()
                    .imageUrl(imageUrl)
                    .boardId(board.getId())
                    .build();
            imageRepository.save(image);
        }

        return GetBoardDetailDto.fromEntity(board, saveBoardDto.getImages());
    }

    @Override
    public GetBoardDetailDto getBoardById(Long id) {
        List<String> images = new ArrayList<>();
        Board board = boardRepository.findByBoardId(id);

        List<Image> imageList = imageRepository.findByBoardId(id);
        for (Image image : imageList)
            images.add(image.getImageUrl());

        return GetBoardDetailDto.fromEntity(board, images);
    }

    @Override
    public GetBoardDetailDto updateBoard(Long id, PatchBoardDto patchBoardDto, User user) {
        List<String> images = new ArrayList<>();

        // 유저id, 게시글id 유효성 검사
        boardValidate(id, user);

        List<Image> imageList = imageRepository.findByBoardId(id);
        for (Image image : imageList)
            images.add(image.getImageUrl());

        Board board = Board.builder()
                .title(patchBoardDto.getTitle())
                .content(patchBoardDto.getContent())
                .build();

        boardRepository.update(board);



        return GetBoardDetailDto.fromEntity(board, images);
    }

    @Override
    public void withdraw(Long id, User user) {
        // 유저id, 게시글id 유효성 검사
        boardValidate(id, user);

        boardRepository.delete(id);
    }

    private void boardValidate(Long id, User user) {
        if (!boardRepository.existByBoardId(id))
            throw new BadRequestException(ErrorCode.BOARD_NOT_FOUND);

        Board existBoard = boardRepository.findByBoardId(id);
        if (existBoard.getUserId() != user.getId())
            throw new UnauthorizedException(ErrorCode.FORBIDDEN_USER);
    }
}

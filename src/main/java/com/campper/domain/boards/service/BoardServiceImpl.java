package com.campper.domain.boards.service;

import com.campper.domain.boards.dto.request.PatchBoardDto;
import com.campper.domain.boards.dto.request.SaveBoardDto;
import com.campper.domain.boards.dto.response.GetBoardDetailDto;
import com.campper.domain.boards.entity.Board;
import com.campper.domain.boards.entity.Image;
import com.campper.domain.boards.repository.BoardRepository;
import com.campper.domain.boards.repository.ImageRepository;
import com.campper.domain.users.entity.User;
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
        Board board = boardRepository.findByBoardId(id);

        // id를 가지고 이미지 하나씩 찾아야 함
        List<String> images = new ArrayList<>();
        List<Image> imageList = imageRepository.findByBoardId(id);

        for (Image image : imageList)
            images.add(image.getImageUrl());

        return GetBoardDetailDto.fromEntity(board, images);
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

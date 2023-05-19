package com.campper.domain.boards.repository;

import com.campper.domain.boards.entity.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImageRepository {

    // 사진 저장
    int save(Image image);

    // board id 를 가지고 사진 구하기
    List<Image> findByBoardId(Long id);
}


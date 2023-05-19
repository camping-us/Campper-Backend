package com.campper.domain.like.camps.repository;

import com.campper.domain.like.camps.entity.CampDibs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CampDibsRepository {

    // 유저 좋아요 있는지 확인
    boolean existByCampIdAndUserId(CampDibs campDibs);
    // 찜 누르기
    Long dibs(CampDibs campDibs);
    // 찜 취소하기
    Long dibsCancel(CampDibs campDibs);
}

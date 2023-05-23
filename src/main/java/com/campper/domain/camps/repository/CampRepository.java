package com.campper.domain.camps.repository;

import com.campper.domain.camps.entity.Camp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CampRepository {
    void saveList(List<Camp> camps);
    void updateDibs(Camp camp);
    Camp findById(Long id);
    void increaseDibsCnt(Long id);
    void decreaseDibsCnt(Long id);
}

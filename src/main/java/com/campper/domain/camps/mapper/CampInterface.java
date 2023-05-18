package com.campper.domain.camps.mapper;

import com.campper.domain.camps.entity.Camp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CampInterface {
    void saveList(List<Camp> camps);
    void updateDibs(Camp camp);
}

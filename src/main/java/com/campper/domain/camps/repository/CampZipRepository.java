package com.campper.domain.camps.repository;

import com.campper.domain.camps.entity.CampZip;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CampZipRepository {
    List<CampZip> findAll();
}

package com.campper.domain.like.camps.service;

import com.campper.domain.users.entity.User;

public interface CampDibsService {

    void dibs(Long id, User user);

    boolean checkDibs(Long id, User user);
}

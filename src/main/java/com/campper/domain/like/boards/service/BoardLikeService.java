package com.campper.domain.like.boards.service;

import com.campper.domain.users.entity.User;

public interface BoardLikeService {

    void like(Long id, User user);
}

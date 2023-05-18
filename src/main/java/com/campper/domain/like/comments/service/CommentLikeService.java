package com.campper.domain.like.comments.service;

import com.campper.domain.users.entity.User;

public interface CommentLikeService {

    void like(Long id, User user);
}

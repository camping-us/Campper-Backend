package com.campper.domain.users.repository;

import com.campper.domain.users.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
@Mapper
public interface UserRepository {
    boolean existByAuthKey(String authKey);
    Optional<User> findByAuthKey(String authKey);
    void save(User user);
    User updatePwd(User user);
    User updateProfile(User user);
    void delete(User user);
}

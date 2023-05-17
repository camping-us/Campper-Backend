package com.campper.domain.users.repository;

import com.campper.domain.users.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
@Mapper
public interface UserRepository {
    boolean existByAuthKey(String authKey);
    User findById(Long id);
    Optional<User> findByAuthKey(String authKey);
    void save(User user);
    void updatePwd(User user);
    void updateProfile(User user);
    void delete(User user);
}

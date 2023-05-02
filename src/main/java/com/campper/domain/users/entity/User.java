package com.campper.domain.users.entity;

import com.campper.global.common.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class User extends BaseEntity {
    private Long id;
    private String authKey;
    private String email;
    private String pwd;
    private LocalDate birth;
    private String nickName;
    private String profileImg;
    private Role role;

    @Builder
    public User(String authKey, String email, String pwd, LocalDate birth, String nickName, String profileImg, Role role) {
        this.authKey = authKey;
        this.email = email;
        this.pwd = pwd;
        this.birth = birth;
        this.nickName = nickName;
        this.profileImg = profileImg;
        this.role = role;
    }

    public void updatePwd(String pwd) {
        this.pwd = pwd;
    }

    public void updateProfile(String nickName, String profileImg) {
        this.nickName = nickName;
        this.profileImg = profileImg;
    }
}

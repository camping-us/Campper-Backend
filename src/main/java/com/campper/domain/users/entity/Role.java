package com.campper.domain.users.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ROLE_USER("사용자"),
    ROLE_ADMIN("관리자");

    private String viewName;

//    @JsonCreator
//    public static Role fromDto (String viewName){
//        for(Role role: Role.values()){
//            if(role.getViewName().equals(viewName)){
//                return role;
//            }
//        }
//        return null;
//    }
}

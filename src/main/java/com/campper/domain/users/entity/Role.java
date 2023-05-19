package com.campper.domain.users.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

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

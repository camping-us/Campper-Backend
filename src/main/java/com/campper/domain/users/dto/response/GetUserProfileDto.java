package com.campper.domain.users.dto.response;

import com.campper.domain.users.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class GetUserProfileDto {

    @ApiModelProperty(notes = "사용자 아이디", required = true)
    private Long id;
    @ApiModelProperty(notes = "생년월일", required = true)
    private LocalDate birth;
    @ApiModelProperty(notes = "닉네임", required = true)
    private String nickName;
    @ApiModelProperty(notes = "프로필 이미지", required = true)
    private String profileImg;
    @ApiModelProperty(notes = "이메일", required = true)
    private String email;

    @Builder
    public GetUserProfileDto(Long id, LocalDate birth, String nickName, String profileImg, String email) {
        this.id = id;
        this.birth = birth;
        this.nickName = nickName;
        this.profileImg = profileImg;
        this.email = email;
    }

    public static GetUserProfileDto fromEntity(User user){
        return GetUserProfileDto.builder()
                .id(user.getId())
                .birth(user.getBirth())
                .nickName(user.getNickName())
                .profileImg(user.getProfileImg())
                .email(user.getEmail())
                .build();
    }
}

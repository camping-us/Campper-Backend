package com.campper.domain.users.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostUserDto {
    @ApiModelProperty(value = "사용자 아이디", example = "U123456789")
    @NotNull
    private String authKey;
    @ApiModelProperty(value = "사용자 이메일 주소", example = "U12345789@naver.com")
    @Email
    private String email;
    @ApiModelProperty(value = "사용자 비밀번호", example = "U123456789!")
    @NotNull
    private String pwd;
    @ApiModelProperty(value = "사용자 생년월일", example = "1998-02-14")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;
    @ApiModelProperty(value = "사용자 별명", example = "UNAME123456789")
    @NotNull
    private String nickName;
}

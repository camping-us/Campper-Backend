package com.campper.global.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* Common */
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "Invalid Input Value"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C000", "서버 에러, 관리자에게 문의 바랍니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "C001", "잘못된 요청입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C003", "지원하지 않는 Http Method 입니다."),


    /* Auth */
    UNAUTHORIZED_ACCESS(UNAUTHORIZED, "AUTH000", "권한이 없습니다."),
    EXPIRED_TOKEN(HttpStatus.BAD_REQUEST, "AUTH001", "만료된 엑세스 토큰입니다"),
    INVALID_REFRESH_TOKEN(HttpStatus.BAD_REQUEST, "AUTH002", "리프레시 토큰이 유효하지 않습니다"),
    MISMATCH_REFRESH_TOKEN(HttpStatus.BAD_REQUEST, "AUTH003", "리프레시 토큰의 유저 정보가 일치하지 않습니다"),
    INVALID_AUTH_TOKEN(UNAUTHORIZED, "AUTH004", "권한 정보가 없는 토큰입니다"),
    UNAUTHORIZED_USER(UNAUTHORIZED, "AUTH005", "현재 내 계정 정보가 존재하지 않습니다"),
    REFRESH_TOKEN_NOT_FOUND(NOT_FOUND, "AUTH006", "로그아웃 된 사용자입니다"),
    FORBIDDEN_USER(FORBIDDEN, "AUTH007", "권한이 없는 유저입니다"),
    LOGIN_FAILED(UNAUTHORIZED, "AUTH008", "로그인에 실패했습니다"),
    INVALID_TOKEN(HttpStatus.BAD_REQUEST, "AUTH009", "유효하지 않은 토큰입니다"),
    INVALID_PRINCIPAL(HttpStatus.BAD_REQUEST, "AUTH010", "인증정보가 존재하지 않습니다"),
    INVALID_PASSWORD(UNAUTHORIZED, "AUTH011", "비밀번호가 일치하지 않습니다."),

    /* User */
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER001", "해당 유저가 존재하지 않습니다."),
    DUPLICATE_AUTHKEY(HttpStatus.BAD_REQUEST,"USER002","아이디 중복 입니다."),

    /* Board */
    BOARD_NOT_FOUND(HttpStatus.BAD_REQUEST, "BOARD001", "해당 게시글이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}

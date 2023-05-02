package com.campper.global.common.response;

import com.campper.global.common.error.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.json.JSONObject;

import java.time.LocalDateTime;

/**
 * api 공통 응답 형식입니다.
 */
@Getter
public class CommonResponse<T> {
    @JsonProperty("status")
    private int code;

    @JsonProperty("isSuccess")
    private boolean success;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @Builder
    public CommonResponse(int code, boolean success, String message, T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> onSuccess(int code) {
        return CommonResponse.<T>builder()
                .code(code)
                .success(true)
                .message("요청에 성공하였습니다.")
                .build();
    }

    public static <T> CommonResponse<T> onSuccess(int code, T data) {
        return CommonResponse.<T>builder()
                .code(code)
                .success(true)
                .message("요청에 성공하였습니다.")
                .data(data)
                .build();
    }

    /**
     * filter chain 을 위한 JSON 생성자
     */
    public static JSONObject jsonOf(ErrorCode errorCode) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("timestamp", LocalDateTime.now());
        jsonObject.put("success", false);
        jsonObject.put("message", errorCode.getMessage());
        jsonObject.put("status", errorCode.getHttpStatus().value());
        jsonObject.put("code", errorCode.getCode());
        return jsonObject;
    }
}

package com.campper.global.common.error.exception;



import com.campper.global.common.error.ErrorCode;
import lombok.Getter;

/**
 * status : 400
 */
@Getter
public class BadRequestException extends BaseException {
    public BadRequestException() {
        super(ErrorCode.BAD_REQUEST, ErrorCode.BAD_REQUEST.getMessage());
    }
    public BadRequestException(String message) {
        super(ErrorCode.BAD_REQUEST, message);
    }
    public BadRequestException(ErrorCode errorCode) {
        super(errorCode, errorCode.getMessage());
    }
}

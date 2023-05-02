package com.campper.global.common.error.exception;

import com.campper.global.common.error.ErrorCode;
import lombok.Getter;

/**
 * status : 404
 */
@Getter
public class NotFoundException extends BaseException {
    public NotFoundException() {
        super(ErrorCode.BAD_REQUEST, ErrorCode.BAD_REQUEST.getMessage());
    }
    public NotFoundException(String message) {
        super(ErrorCode.BAD_REQUEST, message);
    }
    public NotFoundException(ErrorCode errorCode) {
        super(errorCode, errorCode.getMessage());
    }
}

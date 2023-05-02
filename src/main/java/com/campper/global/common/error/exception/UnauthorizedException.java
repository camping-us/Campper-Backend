package com.campper.global.common.error.exception;

import com.campper.global.common.error.ErrorCode;
import lombok.Getter;

/**
 * status : 401
 */
@Getter
public class UnauthorizedException extends BaseException {
    public UnauthorizedException() {
        super(ErrorCode.UNAUTHORIZED_ACCESS, ErrorCode.UNAUTHORIZED_ACCESS.getMessage());
    }
    public UnauthorizedException(String message) {
        super(ErrorCode.UNAUTHORIZED_ACCESS, message);
    }
    public UnauthorizedException(ErrorCode errorCode) {
        super(errorCode, errorCode.getMessage());
    }
}

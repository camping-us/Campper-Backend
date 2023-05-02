package com.campper.global.common.error.exception;

import com.campper.global.common.error.ErrorCode;
import lombok.Getter;

/**
 * status : 500
 */
@Getter
public class InternalServerException extends BaseException {
    public InternalServerException() {
        super(ErrorCode.INTERNAL_SERVER_ERROR, ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
    }
    public InternalServerException(String message) {
        super(ErrorCode.INTERNAL_SERVER_ERROR, message);
    }

    public InternalServerException(ErrorCode errorCode) {
        super(errorCode, errorCode.getMessage());
    }
}

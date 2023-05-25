package com.campper.global.common.error;

import com.campper.global.common.error.exception.BaseException;
import com.campper.global.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@ApiIgnore
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 로컬 로그인 실패시 발생하는 오류
     * */
    @ExceptionHandler({BadCredentialsException.class, InternalAuthenticationServiceException.class,
            UsernameNotFoundException.class, AuthenticationCredentialsNotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleAuthenticationException(Exception ex) {
        log.error("Exception", ex);
        return new ResponseEntity<>(ErrorResponse.onFailure(ErrorCode.LOGIN_FAILED),
                null, ErrorCode.LOGIN_FAILED.getHttpStatus());
    }

    /**
     * @Valid 으로 binding error 시 발생
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException MANVE) {
        log.error("MethodArgumentNotValidException", MANVE);
        return new ResponseEntity<>(ErrorResponse.onFailure(ErrorCode.BAD_REQUEST),
                null, ErrorCode.BAD_REQUEST.getHttpStatus());
    }

    /**
     * Enum 값이 유효하지 않을 때
     */
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidatedException(MethodArgumentNotValidException MANVE) {
        log.error("MethodArgumentNotValidException", MANVE);
        return new ResponseEntity<>(ErrorResponse.onFailure(ErrorCode.BAD_REQUEST),
                null, ErrorCode.BAD_REQUEST.getHttpStatus());
    }

    /**
     * 지원하지 않는 http method 호출시 발생하는 에러
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("HttpRequestMethodNotSupportedException", e);
        return new ResponseEntity<>(ErrorResponse.onFailure(ErrorCode.METHOD_NOT_ALLOWED),
                null, ErrorCode.METHOD_NOT_ALLOWED.getHttpStatus());
    }

    /**
     * JSON parse error 일 경우에 발생합니다
     * request 값을 읽을 수 없을 때 발생합니다.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("HttpMessageNotReadableException", e);
        return new ResponseEntity<>(ErrorResponse.onFailure(ErrorCode.BAD_REQUEST),
                null, ErrorCode.BAD_REQUEST.getHttpStatus());
    }

    /**
     * 변수 타입이 맞지 않을 때 발생하는 에러입니다.
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("MethodArgumentTypeMismatchException", e);
        return new ResponseEntity<>(ErrorResponse.onFailure(ErrorCode.BAD_REQUEST),
                null, ErrorCode.BAD_REQUEST.getHttpStatus());
    }

    /**
     * 변수 타입이 맞지 않을 때 발생하는 에러입니다.
     */
    @ExceptionHandler(EmptyResultDataAccessException.class)
    protected ResponseEntity<ErrorResponse> handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        log.error("EmptyResultDataAccessException", e);
        return new ResponseEntity<>(ErrorResponse.onFailure(ErrorCode.BAD_REQUEST),
                null, ErrorCode.BAD_REQUEST.getHttpStatus());
    }

    /**
     * 비즈니스 로직 에러 처리
     */
    @ExceptionHandler(BaseException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(final BaseException baseException) {
        log.error("handleBusinessException", baseException);
        return new ResponseEntity<>(ErrorResponse.onFailure(baseException.getErrorCode()),
                null, baseException.getErrorCode().getHttpStatus());
    }

    /**
     * 위에서 따로 처리하지 않은 에러를 모두 처리해줍니다.
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.error("handleException", exception);
        return new ResponseEntity<>(ErrorResponse.onFailure(ErrorCode.INTERNAL_SERVER_ERROR),
                null, INTERNAL_SERVER_ERROR);
    }

}

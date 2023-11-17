package org.woofteam.immortalcultivationplan.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.woofteam.immortalcultivationplan.common.message.response.ResultResponse;
import org.woofteam.immortalcultivationplan.common.message.result.ExceptionEnum;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class,
            ConstraintViolationException.class, BindException.class})
    public ResponseEntity<Object> handleValidatedException(Exception e) {
        log.error("拦截到参数校验未通过，异常信息：" + e.getMessage());
        String errorMsg = "参数校验未通过： ";
        if (e instanceof MethodArgumentNotValidException ex) {
            //@RequestBody参数校验报错
            log.error("Handler MethodArgumentNotValidException, msg: {}", e.getMessage());
            errorMsg = errorMsg + ex.getFieldErrors()
                    .stream()
                    .map(FieldError::getField)
                    .collect(Collectors.joining("," + " "));
        } else if (e instanceof ConstraintViolationException ex) {
            // 直接校验具体参数报错
            log.error("Handler ConstraintViolationException, msg: {}", e.getMessage());
            errorMsg = errorMsg + ex.getMessage();
        } else if (e instanceof BindException) {
            //校验对象参数报错
            log.error("Handler BindException, msg: {}", e.getMessage());
            BindException ex = (BindException) e;
//            errorMsg = errorMsg + ex.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "));
        }
        return new ResponseEntity<>(
                ResultResponse.fail(ExceptionEnum.BODY_NOT_MATCH, e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {VerifyException.class})
    public ResponseEntity<Object> handlerVerifyException(VerifyException e) {
        log.error("Handler VerifyException, msg: {}", e.getMessage());
        return new ResponseEntity<>(
                ResultResponse.fail(ExceptionEnum.INTERNAL_SERVER_ERROR, e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ResultException.class})
    public ResponseEntity<Object> handlerResultException(ResultException e) {
        log.error("Handler ResultException, msg: {}", e.getMessage());
        return new ResponseEntity<>(
                ResultResponse.fail(ExceptionEnum.INTERNAL_SERVER_ERROR, e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ResponseEntity<Object> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException e) {
        log.error("Handler MissingServletRequestParameterException, msg: {}", e.getMessage());
        return new ResponseEntity<>(
                ResultResponse.fail(ExceptionEnum.INTERNAL_SERVER_ERROR, e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception e) {
        log.error("Handler Exception: ", e);
        return new ResponseEntity<>(
                ResultResponse.fail(ExceptionEnum.INTERNAL_SERVER_ERROR, e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
package org.woofteam.immortalcultivationplan.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.woofteam.immortalcultivationplan.dao.ResultResponse;
import org.woofteam.immortalcultivationplan.dto.ExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public ResultResponse<String> handleValidatedException(Exception e) {
        log.error("拦截到参数校验未通过，异常信息：" + e.getMessage());
        //@RequestBody参数校验报错
        String errorMsg = "参数校验未通过： ";
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            errorMsg =
                    errorMsg + ex.getFieldErrors()
                            .stream()
                            .map(x -> x.getField())
                            .collect(Collectors.joining("," + " "));
            // 直接校验具体参数报错
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException ex = (ConstraintViolationException) e;
            errorMsg =
                    errorMsg + ex.getMessage();
            //校验对象参数报错
        } else if (e instanceof BindException) {
            BindException ex = (BindException) e;
//            errorMsg = errorMsg + ex.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "));
        }
        return new ResultResponse<>(ExceptionEnum.BODY_NOT_MATCH,errorMsg);
    }
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ResultResponse<String> getHandleParamException(MissingServletRequestParameterException e){

        return new ResultResponse<>(e.getMessage());
    }
    @ExceptionHandler(value = {Exception.class})
    public ResultResponse<String> getHandleException(Exception e){
        return new ResultResponse<>(e.getMessage());
    }
}
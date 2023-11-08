package org.woofteam.immortalcultivationplan.dao;


import lombok.Data;
import org.woofteam.immortalcultivationplan.dto.ExceptionEnum;

@Data
public class ResultResponse<T> {
    private String message;
    private String code;

    private T body;
    public ResultResponse() {
        this.code= ExceptionEnum.SUCCESS.getResultCode();
        this.message=ExceptionEnum.SUCCESS.getResultMsg();
    }
    public ResultResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }
    public ResultResponse(ExceptionEnum exceptionEnum, T body) {
        this.message = exceptionEnum.getResultMsg();
        this.code = exceptionEnum.getResultCode();
        this.body = body;
    }

    public ResultResponse(T body) {
        this.code=ExceptionEnum.SUCCESS.getResultCode();
        this.message=ExceptionEnum.SUCCESS.getResultMsg();
        this.body = body;
    }
}

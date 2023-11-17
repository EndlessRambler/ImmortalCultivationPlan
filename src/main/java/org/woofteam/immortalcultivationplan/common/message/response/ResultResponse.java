package org.woofteam.immortalcultivationplan.common.message.response;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import org.woofteam.immortalcultivationplan.common.message.result.ExceptionEnum;

@Data
public class ResultResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;

    private String code;

    private T data;

    public ResultResponse() {
        this.code = ExceptionEnum.SUCCESS.getResultCode();
        this.message = ExceptionEnum.SUCCESS.getResultMsg();
    }

    public ResultResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public ResultResponse(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getResultCode();
        this.message = exceptionEnum.getResultMsg();
        this.data = null;
    }

    public ResultResponse(ExceptionEnum exceptionEnum, String message) {
        this.code = exceptionEnum.getResultCode();
        this.message = message;
        this.data = null;
    }

    public ResultResponse(T data) {
        this.code = ExceptionEnum.SUCCESS.getResultCode();
        this.message = ExceptionEnum.SUCCESS.getResultMsg();
        this.data = data;
    }

    public static ResultResponse<Object> fail(ExceptionEnum exceptionEnum) {
        return new ResultResponse<>(exceptionEnum);
    }

    public static ResultResponse<Object> fail(ExceptionEnum exceptionEnum, String message) {
        return new ResultResponse<>(exceptionEnum, message);
    }

    public static ResultResponse<Object> success() {
        return new ResultResponse<>(ExceptionEnum.SUCCESS);
    }

    /**
     * 对于声明了<T>的类(Test1<T>就是声明了<T>的类)不需要声明泛型方法,对于带了static的方法, 它并不属于类的一部分,所以相当于没有声明<T>的类,所以需要声明为泛型方法
     *
     * @param body
     * @param <T>
     * @return
     */
    public static <T> ResultResponse<T> success(T body) {
        return new ResultResponse<>(body);
    }
}

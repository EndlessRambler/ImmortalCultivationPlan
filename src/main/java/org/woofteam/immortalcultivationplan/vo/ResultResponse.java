package org.woofteam.immortalcultivationplan.vo;


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

    public static ResultResponse setFailed(ExceptionEnum exceptionEnum){
       return new ResultResponse<>(exceptionEnum);
    }

    public static ResultResponse success(){
        return new ResultResponse<>();
    }

    /**
     * 对于声明了<T>的类(Test1<T>就是声明了<T>的类)不需要声明泛型方法,对于带了static的方法,
     * 它并不属于类的一部分,所以相当于没有声明<T>的类,所以需要声明为泛型方法
     *
     * @param body
     * @param <T>
     * @return
     */
    public static <T> ResultResponse success(T body){
        return new ResultResponse<>(body);
    }
}

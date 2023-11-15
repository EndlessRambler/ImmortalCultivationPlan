package org.woofteam.immortalcultivationplan.point;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.woofteam.immortalcultivationplan.vo.ResponseResultBody;
import org.woofteam.immortalcultivationplan.vo.ResultResponse;

import java.lang.annotation.Annotation;
import java.util.Objects;


@RestControllerAdvice
@Slf4j
public class ImmortalResultResponseAdvice implements ResponseBodyAdvice<Object> {
    @Resource
    private ObjectMapper objectMapper;
    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseResultBody.class;
    /**
     *
     * 判断类或者方法是否使用了 @ResponseResultBody
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return  AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE) || returnType.hasMethodAnnotation(ANNOTATION_TYPE);
    }
    /**
     * 当类或者方法使用了 @ResponseResultBody 就会调用这个方法
     */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<?
            extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        //如果返回类型是string，那么springmvc是直接返回的，此时需要手动转化为json
        // 当body都为null时，下面的if判断条件都不满足，如果接口返回类似为String，会报错com.shepherd.fast.global.ResponseVO cannot be cast to java.lang.String
        Class returnClass = returnType.getMethod().getReturnType();
        if(body instanceof String || Objects.equals(returnClass,String.class)){
            String value = objectMapper.writeValueAsString(ResultResponse.success());
        }
        if (body instanceof ResultResponse){
            return body;
        }
        return ResultResponse.success(body);
    }

    @Bean
    public ImmortalResultResponseAdvice responseResultBodyAdvice() {
        return new ImmortalResultResponseAdvice();
    }
}

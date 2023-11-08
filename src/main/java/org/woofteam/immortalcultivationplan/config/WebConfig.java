package org.woofteam.immortalcultivationplan.config;

import org.woofteam.immortalcultivationplan.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor());
        //拦截某个路径下的
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**");
    }
}

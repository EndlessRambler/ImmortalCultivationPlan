package org.woofteam.immortalcultivationplan.interceptor;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.woofteam.immortalcultivationplan.annonation.ImmortalPrivileges;
import org.woofteam.immortalcultivationplan.utils.JWTUtils;

import java.lang.reflect.Method;
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // ①:START 方法注解级拦截器
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        ImmortalPrivileges methodAnnotation = method.getAnnotation(ImmortalPrivileges.class);
        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            log.info("immortal privileges start ......");
            // 这写你拦截需要干的事儿，比如取缓存，SESSION，权限判断等
            String immortalToken = request.getHeader("immortalToken");
            if (immortalToken ==null){
                System.out.println("====================================");
              return false;
            }
            if (!JWTUtils.isExpire(immortalToken)){
                log.info("immortalToken is expire......... ");
                return false;
            }
            log.info("immortal privileges end ......");
            return true;
        }
        log.info("Other Interceptor Done.....");

        return true;
    }
}

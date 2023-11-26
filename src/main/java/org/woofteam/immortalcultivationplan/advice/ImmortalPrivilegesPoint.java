package org.woofteam.immortalcultivationplan.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ImmortalPrivilegesPoint {
    @Pointcut("@annotation(org.woofteam.immortalcultivationplan.annonation.ImmortalPrivileges)")
    public void privileges(){}
    @Before("privileges()")
    public void test(){
        System.out.println("success!");
    }
}

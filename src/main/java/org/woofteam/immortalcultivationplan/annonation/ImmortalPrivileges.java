package org.woofteam.immortalcultivationplan.annonation;

import java.lang.annotation.*;

/**
 * 鉴权
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ResponseResultBody
public @interface ImmortalPrivileges {
    String value() default "";
}

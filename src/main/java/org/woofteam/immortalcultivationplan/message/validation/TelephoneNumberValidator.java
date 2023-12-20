package org.woofteam.immortalcultivationplan.message.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import org.woofteam.immortalcultivationplan.common.message.result.ExceptionEnum;
import org.woofteam.immortalcultivationplan.exception.VerifyException;
import org.woofteam.immortalcultivationplan.message.validation.custom.TelephoneNumber;

import java.lang.annotation.Annotation;

public class TelephoneNumberValidator implements ConstraintValidator<TelephoneNumber,String> {
    private static final String verify="111111";



  @SneakyThrows
  @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s==null || s.isEmpty()) {
            return false;
        }
      return true;
    }

}

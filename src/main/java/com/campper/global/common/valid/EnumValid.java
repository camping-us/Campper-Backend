package com.campper.global.common.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * EnumValidate 확인을 위한 어노테이션입니다.
 * */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EnumValidValidator.class)
public @interface EnumValid {
    String message() default "Invalid Enum";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


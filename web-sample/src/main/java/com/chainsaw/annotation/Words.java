package com.chainsaw.annotation;

import com.chainsaw.validator.WordsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by richard on 8/30/16 10:58 PM.
 */
@Documented
@Constraint(validatedBy = {WordsValidator.class})
@Target({METHOD,FIELD,ANNOTATION_TYPE,PARAMETER,CONSTRUCTOR})
@Retention(RUNTIME)
public @interface Words {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field() default "";
}

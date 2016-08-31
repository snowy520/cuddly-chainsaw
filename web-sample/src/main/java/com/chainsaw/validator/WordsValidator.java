package com.chainsaw.validator;

import com.chainsaw.annotation.Words;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * Created by richard on 8/30/16 10:59 PM.
 */
public class WordsValidator implements ConstraintValidator<Words,String> {

    @Override
    public void initialize(Words constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}

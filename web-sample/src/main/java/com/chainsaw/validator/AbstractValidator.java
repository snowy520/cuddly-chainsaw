package com.chainsaw.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by richard on 9/1/16 9:36 PM.
 */
public abstract class AbstractValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        validate(target, errors, "");
    }

    public abstract void validate(Object target, Errors errors, String... fields);

}

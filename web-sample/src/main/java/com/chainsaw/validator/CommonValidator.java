package com.chainsaw.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Created by richard on 9/1/16 9:46 PM.
 */
public class CommonValidator extends AbstractValidator {

    @Override
    public void validate(Object target, Errors errors, String... fields) {
        ValidationUtils.rejectIfEmpty(errors,"","");
    }

}

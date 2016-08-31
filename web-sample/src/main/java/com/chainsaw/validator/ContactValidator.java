package com.chainsaw.validator;

import com.chainsaw.annotation.ValueValidator;
import com.chainsaw.dto.InParam;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by richard on 8/31/16 10:50 PM.
 */
@ValueValidator
public class ContactValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // isAssignableFrom
        return InParam.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty");
    }

}

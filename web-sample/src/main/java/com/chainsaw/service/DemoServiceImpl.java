package com.chainsaw.service;

import com.chainsaw.dto.InParam;
import com.chainsaw.validator.ContactValidator;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by richard on 8/31/16 10:57 PM.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Inject
    private ContactValidator contactValidator;
    @Override
    public void testValidator(InParam inParam) {
        Errors errors = new BeanPropertyBindingResult(inParam, inParam.getName());
        contactValidator.validate(inParam,errors);

//        ValidationUtils.invokeValidator(contactValidator,inParam,errors);

        List<ObjectError> allErrors = errors.getAllErrors();
        for (ObjectError error : allErrors) {
            System.out.println(error.getDefaultMessage()+"\n");
        }
    }
}

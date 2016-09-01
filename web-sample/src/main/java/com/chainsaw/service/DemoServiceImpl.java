package com.chainsaw.service;

import com.chainsaw.app.WebAppConfig;
import com.chainsaw.app.WebMvcConfig;
import com.chainsaw.bean.Company;
import com.chainsaw.bean.InParam;
import com.chainsaw.validator.ContactValidator;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

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

        BeanWrapper beanWrapper = new BeanWrapperImpl(new Company());
        beanWrapper.setPropertyValue("name","company_name");
        PropertyValue value = new PropertyValue("address", "Some Company Inc.");
        beanWrapper.setPropertyValue(value);

        Object address = beanWrapper.getPropertyValue("address");
        System.out.println(address);

        Errors errors = new BeanPropertyBindingResult(inParam, inParam.getName());
        contactValidator.validate(inParam,errors);

//        ValidationUtils.invokeValidator(contactValidator,inParam,errors);

        List<ObjectError> allErrors = errors.getAllErrors();
        for (ObjectError error : allErrors) {
            System.out.println(error.getDefaultMessage()+"\n");
        }
    }

    public static void main(String[] args) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebAppConfig.class, WebMvcConfig.class);
        context.setServletConfig(new MockServletConfig());
        context.refresh();
        DemoService demoService = context.getBean(DemoService.class);
        InParam inParam = new InParam();
        demoService.testValidator(inParam);
    }

}

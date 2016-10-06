package com.chainsaw.service;

import com.chainsaw.app.WebAppConfig;
import com.chainsaw.app.WebMvcConfig;
import com.chainsaw.bean.Company;
import com.chainsaw.bean.InParam;
import com.chainsaw.validator.ContactValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by richard on 8/31/16 10:57 PM.
 */
@Service
public class DemoServiceImpl implements DemoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Inject
    private ContactValidator contactValidator;

    @Inject
    private Validator validator;

    @Override
    public void testValidator(@Validated InParam inParam) {

        BeanWrapper beanWrapper = new BeanWrapperImpl(new Company());
        beanWrapper.setPropertyValue("name","company_name");
        PropertyValue value = new PropertyValue("address", "Some Company Inc.");
        beanWrapper.setPropertyValue(value);

        Object address = beanWrapper.getPropertyValue("address");
        System.out.println(address);



        Errors errors = new BeanPropertyBindingResult(inParam, inParam.getName());

//        validator.validate(inParam,errors);

        contactValidator.validate(inParam,errors);

//        ValidationUtils.invokeValidator(contactValidator,inParam,errors);

        List<ObjectError> allErrors = errors.getAllErrors();
        for (ObjectError error : allErrors) {
            System.out.println(error.getDefaultMessage()+"\n");
        }
    }

    @Cacheable(value = "findCache",cacheManager = "cacheManager")
    @Override
    public List<Company> testCache() {
        List<Company> companyList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Company company = new Company();
            company.setName(UUID.randomUUID().toString());
            companyList.add(company);
        }
        return companyList;
    }

    public static void main(String[] args) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.getEnvironment().setActiveProfiles("dev");
        context.register(WebAppConfig.class, WebMvcConfig.class);
        context.setServletConfig(new MockServletConfig());
        context.refresh();
        DemoService demoService = context.getBean(DemoService.class);
//        InParam inParam = new InParam();
//        inParam.setName("xx");
//        demoService.testValidator(inParam);

        List<Company> companyList = demoService.testCache();
        demoService.testCache();
        demoService.testCache();
        demoService.testCache();
        System.out.println(companyList.size());

    }

}

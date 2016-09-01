package com.chainsaw.app;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by richard on 8/30/16 9:38 PM.
 */
@Configuration
@ComponentScan(basePackages = {"com.chainsaw"},
        excludeFilters =  @ComponentScan.Filter(classes = {RestController.class,Controller.class}))
@PropertySource(value = {"classpath:/webapp.properties"})
public class WebAppConfig {

    @Bean
    public MethodValidationPostProcessor validationPostProcessor() {
        MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
//        methodValidationPostProcessor.setValidatorFactory(new LocalValidatorFactoryBean());
//        methodValidationPostProcessor.setValidator(new LocalValidatorFactoryBean());
        return methodValidationPostProcessor;
    }

    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        return localValidatorFactoryBean;
    }

}

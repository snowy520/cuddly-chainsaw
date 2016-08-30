package com.chainsaw.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by richard on 8/30/16 9:38 PM.
 */
@Configuration
@ComponentScan(basePackages = {"com.chainsaw"},
        excludeFilters =  @ComponentScan.Filter(classes = {RestController.class,Controller.class}))
@PropertySource(value = {"classpath:/webapp.properties"})
public class WebAppConfig {



}

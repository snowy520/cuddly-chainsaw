package com.chainsaw.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by richard on 8/30/16 9:39 PM.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.chainsaw.controller"})
public class WebMvcConfig {

}

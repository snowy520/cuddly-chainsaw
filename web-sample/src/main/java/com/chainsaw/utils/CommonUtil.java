package com.chainsaw.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by richard on 8/31/16 10:03 PM.
 */
public final class CommonUtil {

    public static String convertToString(BindingResult bindingResult) {
        Assert.notNull(bindingResult);
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if(CollectionUtils.isEmpty(allErrors)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError objectError : allErrors) {
            stringBuilder.append(objectError.getDefaultMessage()+"\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

//        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(null);

        Resource resource = new ClassPathResource("messages.properties");
        try {
            String string = FileCopyUtils.copyToString(new FileReader(resource.getFile()));
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // PropertiesLoaderUtils
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("messages.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

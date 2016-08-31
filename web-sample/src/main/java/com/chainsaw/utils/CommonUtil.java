package com.chainsaw.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by richard on 8/31/16 10:03 PM.
 */
public final class CommonUtil {

    public static String convertToString(BindingResult bindingResult) {
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

}

package com.chainsaw.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by richard on 8/30/16 9:46 PM.
 */
@ControllerAdvice
public class CommonControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map aaa(Exception exception) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("exception", exception);
        return hashMap;
    }


}

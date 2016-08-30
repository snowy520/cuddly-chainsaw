package com.chainsaw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by richard on 8/30/16 9:47 PM.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/test")
    public Map hello() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("xx","xxx");
        return hashMap;
    }

}

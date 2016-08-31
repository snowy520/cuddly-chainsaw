package com.chainsaw.controller;

import com.chainsaw.dto.InParam;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by richard on 8/30/16 9:47 PM.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/test",
            method = {RequestMethod.GET,RequestMethod.POST},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map hello(@Valid @RequestBody InParam inParam) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("xx","xxx");
        return hashMap;
    }

}

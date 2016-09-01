package com.chainsaw.controller;

import com.chainsaw.bean.InParam;
import com.chainsaw.service.DemoService;
import com.chainsaw.utils.CommonUtil;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by richard on 8/30/16 9:47 PM.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Inject
    private DemoService demoService;

    @RequestMapping(value = "/test",
            method = {RequestMethod.GET,RequestMethod.POST},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map hello(@Valid @RequestBody InParam inParam, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
//            System.out.println(new Gson().toJson(bindingResult.getModel()));
            throw new IllegalArgumentException(CommonUtil.convertToString(bindingResult));
        }
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("start",""+System.currentTimeMillis());
        return hashMap;
    }

    @RequestMapping(value = "/spring",
            method = {RequestMethod.GET,RequestMethod.POST},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map hello2(@RequestBody InParam inParam) {
        demoService.testValidator(inParam);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("start",""+System.currentTimeMillis());
        return hashMap;
    }

}

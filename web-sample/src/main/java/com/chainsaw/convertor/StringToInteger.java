package com.chainsaw.convertor;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by richard on 9/1/16 10:00 PM.
 */
public class StringToInteger implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        return Integer.parseInt(source);
    }

}

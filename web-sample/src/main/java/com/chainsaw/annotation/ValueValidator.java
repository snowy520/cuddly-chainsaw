package com.chainsaw.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.Inherited;

/**
 * Created by richard on 8/31/16 10:51 PM.
 */
@Inherited
@Component
public @interface ValueValidator {
    String value() default "";
}

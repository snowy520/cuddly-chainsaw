package com.chainsaw;

import groovy.lang.GroovyClassLoader;
import groovy.lang.Script;

import java.io.File;

/**
 * Created by richard on 9/3/16 9:37 PM.
 */
public class TestGroovy {

    public static void main(String[] args) {
        String groovy = "class Foo { void doIt() { println \"ok\" } }";
        GroovyClassLoader groovyLoader = new GroovyClassLoader();
        Class<String> groovyClass = groovyLoader.parseClass(groovy);
        try {
            String groovyScript = groovyClass.newInstance();
            System.out.println(groovyScript);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

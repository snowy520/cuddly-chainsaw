package com.chainsaw;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;
import groovy.lang.Script;

import java.io.*;
import java.util.Date;

/**
 * Created by richard on 9/3/16 9:37 PM.
 */
public class TestGroovy {

    public static void main(String[] args) {
        try {
            test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test1() throws IOException, IllegalAccessException, InstantiationException {
        GroovyClassLoader classLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader());
        File sourceFile = new File("groovy-sample/src/main/groovy/com/chainsaw/MyGroovy.groovy");
        Class testGroovyClass = classLoader.parseClass(new GroovyCodeSource(sourceFile));
        GroovyObject instance = (GroovyObject)testGroovyClass.newInstance();//proxy
        Long time = (Long)instance.invokeMethod("getTime", new Date());
        System.out.println(time);
        Date date = (Date)instance.invokeMethod("getDate", time);
        System.out.println(date);
        //here
        instance = null;
        testGroovyClass = null;
    }

    public static void load() throws Exception {
        GroovyClassLoader classLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader());
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\TestGroovy.class"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        for(;;){
            int i = bis.read();
            if( i == -1){
                break;
            }
            bos.write(i);
        }
        Class testGroovyClass = classLoader.defineClass(null, bos.toByteArray());
        //instance of proxy-class
        GroovyObject instance = (GroovyObject)testGroovyClass.newInstance();
        Long time = (Long)instance.invokeMethod("getTime", new Date());
        System.out.println(time);
        Date date = (Date)instance.invokeMethod("getDate", time);
        System.out.println(date.getTime());

        //here
        bis.close();
        bos.close();
        instance = null;
        testGroovyClass = null;
    }

}

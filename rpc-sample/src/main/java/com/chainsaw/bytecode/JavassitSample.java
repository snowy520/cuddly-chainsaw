package com.chainsaw.bytecode;

import javassist.*;

import java.io.IOException;

/**
 * Created by richard on 09/11/2016 9:43 PM.
 */
public class JavassitSample {

    public static void main(String[] args) {

        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("com.samples.Programmer");

        try {
            CtMethod ctMethod = CtNewMethod.make("public void code(){}", ctClass);
            ctMethod.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");

            ctClass.addMethod(ctMethod);
            ctClass.writeFile("test");
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

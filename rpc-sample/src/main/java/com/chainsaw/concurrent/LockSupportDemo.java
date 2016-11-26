package com.chainsaw.concurrent;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by richard on 26/11/2016 7:37 PM.
 */
public class LockSupportDemo {

    public static void main(String[] args) {
        LockSupportDemo demo = new LockSupportDemo();
        demo.test();
    }

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void test() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        threadLocalRandom.nextInt(10);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("sssssss");
                System.out.println("start game");
                LockSupport.park();
                System.out.println("do xxx");
                System.out.println(threadLocal.get());
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("call to do xxx");
        LockSupport.unpark(thread);
    }

}

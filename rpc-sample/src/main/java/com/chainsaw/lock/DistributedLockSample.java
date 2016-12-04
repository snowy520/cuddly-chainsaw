package com.chainsaw.lock;

import org.redisson.Redisson;
import org.redisson.api.RExecutorService;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * Created by richard on 27/11/2016 9:30 PM.
 */
public class DistributedLockSample {

    public static void main(String[] args) {
        DistributedLockSample sample = new DistributedLockSample();
        sample.testLock();
    }

    public void test() {
        // 1. Create config object
        RedissonClient redisson = getRedissonClient();
        // 3. Get object you need
        RMap<String, String> map = redisson.getMap("myMap");
        RLock lock = redisson.getLock("myLock");
        RExecutorService executor = redisson.getExecutorService("myExecutorService");
    }

    private RedissonClient getRedissonClient() {
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379");
        // 2. Create Redisson instance
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

    private RedissonClient getRedissonClient0() {
        return null;
    }

    public void testLock() {
        System.out.println("start >>>>>>>>>>");
        RedissonClient redisson = getRedissonClient();
        // 3. Get object you need
        RLock lock = redisson.getLock("myLock");
        try {
            lock.tryLock(100, 10 , TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.println("end >>>>>>>>>>");
    }

}

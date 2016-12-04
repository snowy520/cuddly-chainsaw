package com.chainsaw.lock;

import org.redisson.Redisson;
import org.redisson.api.RExecutorService;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Created by richard on 27/11/2016 9:30 PM.
 */
public class DistributedLockSample {

    public static void main(String[] args) {

    }

    public void test() {
        // 1. Create config object
        Config config = new Config();
        // 2. Create Redisson instance
        RedissonClient redisson = Redisson.create(config);
        // 3. Get object you need
        RMap<String, String> map = redisson.getMap("myMap");
        RLock lock = redisson.getLock("myLock");
        RExecutorService executor = redisson.getExecutorService("myExecutorService");
    }

}

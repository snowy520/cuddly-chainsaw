package com.chainsaw.lock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * Created by richard on 04/12/2016 3:34 PM.
 */
public class RedisLock implements DistributedLock {
    private final static String LOCKER_PREFIX = "lock:";

    @Override
    public <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws Exception {
        return lock(resourceName, worker, 100);
    }

    @Override
    public <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws Exception {
        RedissonClient redisson = getRedissonClient();
        RLock lock = redisson.getLock(LOCKER_PREFIX + resourceName);
        // Wait for 100 seconds seconds and automatically unlock it after lockTime seconds
        boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);;
        if (success) {
            try {
                return worker.invokeAfterLockAquire();
            } finally {
                lock.unlock();
            }
        }
        return null;
    }

    private RedissonClient getRedissonClient() {
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379");
        // 2. Create Redisson instance
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}

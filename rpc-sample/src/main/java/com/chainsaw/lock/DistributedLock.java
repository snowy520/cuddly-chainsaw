package com.chainsaw.lock;

/**
 * Created by richard on 04/12/2016 3:32 PM.
 */
public interface DistributedLock {
    <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws Exception;

    <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws Exception;

}


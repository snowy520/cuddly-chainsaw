package com.chainsaw.lock;

/**
 * Created by richard on 04/12/2016 3:33 PM.
 */
public interface AquiredLockWorker<T> {
    T invokeAfterLockAquire() throws Exception;
}

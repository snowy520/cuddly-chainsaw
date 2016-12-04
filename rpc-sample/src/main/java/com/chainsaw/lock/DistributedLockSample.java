package com.chainsaw.lock;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.redisson.connection.ConnectionListener;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * Created by richard on 27/11/2016 9:30 PM.
 */
public class DistributedLockSample {

    public static void main(String[] args) {
        DistributedLockSample sample = new DistributedLockSample();
        sample.test();
    }

    public void test() {
        // 1. Create config object
        RedissonClient redisson = getRedissonClient();
        // 3. Get object you need
        RMap<String, String> map = redisson.getMap("myMap");
        map.put("0", "yyy");
        map.fastPut("1","xxxx");
        map.fastRemove("1");

        RRemoteService remoteService = redisson.getRemoteService();
        SomeServiceImpl someServiceImpl = new SomeServiceImpl();
        remoteService.register(SomeServiceInterface.class, someServiceImpl);

        SomeServiceInterface service = remoteService.get(SomeServiceInterface.class);
        String result = service.doSomeStuff(1L, "secondParam", new AnyParam());

//        RLock lock = redisson.getLock("myLock");
//        RExecutorService executor = redisson.getExecutorService("myExecutorService");

//        NodesGroup<Node> nodesGroup = redisson.getNodesGroup();
//        nodesGroup.addConnectionListener(new ConnectionListener() {
//            @Override
//            public void onConnect(InetSocketAddress addr) {
//                System.out.println(addr.getHostString());
//            }
//            @Override
//            public void onDisconnect(InetSocketAddress addr) {
//                System.out.println(addr.getHostString());
//            }
//        });

    }

    private RedissonClient getRedissonClient() {
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379");
        // 2. Create Redisson instance
        RedissonClient redisson = Redisson.create(config);
        return redisson;
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

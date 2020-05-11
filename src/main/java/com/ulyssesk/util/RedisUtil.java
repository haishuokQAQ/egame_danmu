package com.ulyssesk.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {
    private static Jedis jedis;

    public static void initRedis(String host, int port) {
        jedis = new Jedis(host, port);
    }

    public static void setKeyExpire(String key, int expireSec) {
        jedis.setex(key, expireSec,key);
    }

    public static boolean exist(String key) {
        return jedis.exists(key);
    }
    public static void main(String[] args) throws InterruptedException {
        initRedis("39.100.142.29", 6379);
        setKeyExpire("TEST", 20);
        System.out.println(exist("TEST"));
        Thread.sleep(21 * 1000);
        System.out.println(exist("TEST"));
    }
}

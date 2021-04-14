package cn.redis.adapter.Cache.impl;

import cn.redis.adapter.service.CacheService;
import cn.redis.adapter.support.RedisALLConfig;
import cn.redis.adapter.support.RedisConfig;

public class RedisALLCache implements CacheService {
    RedisALLConfig redisConfig = new RedisALLConfig();
    @Override
    public String get(String key) {
        return redisConfig.add(key);
    }
}

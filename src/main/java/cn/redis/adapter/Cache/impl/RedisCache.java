package cn.redis.adapter.Cache.impl;

import cn.redis.adapter.service.CacheService;
import cn.redis.adapter.support.RedisConfig;

public class RedisCache implements CacheService {

    RedisConfig redisConfig = new RedisConfig();
    @Override
    public String get(String key) {
        return redisConfig.add(key);
    }
}
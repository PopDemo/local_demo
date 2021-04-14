package cn.redis.adapter.service.impl;

import cn.redis.adapter.service.CacheService;
import cn.redis.adapter.support.RedisConfig;

import java.util.concurrent.TimeUnit;

public class CacheServiceImpl implements CacheService {


    RedisConfig redisConfig = new RedisConfig();

    @Override
    public String get(String key) {
        return redisConfig.add(key);
    }

}

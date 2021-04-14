package cn.redis.adapter.service;

import java.util.concurrent.TimeUnit;

public interface CacheService {
    String get(final String key);
}

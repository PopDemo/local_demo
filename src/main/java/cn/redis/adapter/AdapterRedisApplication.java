package cn.redis.adapter;

import cn.redis.adapter.Cache.JDKProxy;
import cn.redis.adapter.Cache.impl.RedisALLCache;
import cn.redis.adapter.Cache.impl.RedisCache;
import cn.redis.adapter.service.CacheService;
import cn.redis.adapter.service.impl.CacheServiceImpl;
import org.junit.Test;

public class AdapterRedisApplication {



    @Test
    public void test_CacheService() throws Exception {
        long thisTimeMS = System.currentTimeMillis();
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new
                RedisCache());
        proxy_EGM.get("⼩傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println(val01);

        /**
         * 使用集群的redis
         * 通过反射到集群redis中的方法
         */
        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new
                RedisALLCache());
        proxy_IIR.get("⼩傅哥111");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println(val02);
    }

}

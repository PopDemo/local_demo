package cn.lazy.local.local_test.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class CacheService {
    private final AtomicInteger count = new AtomicInteger(0);

    @Cacheable(value = "erpAppkey_Value")
    public ConcurrentHashMap geterpAppkey(){
        ConcurrentHashMap appkey = new ConcurrentHashMap();
        appkey.put("erpAppKey","123123123");
        if(appkey.mappingCount()>2) {
            throw new RuntimeException("定时erpAppKey出现两个参值");
        }
        count.getAndIncrement();
        log.info("刷新appkey,被调用:{}次",count.get());
        return appkey;
    }


    @CacheEvict(value = "erpAppkey_Value")
    public void delCacheErpAppkey(){
        log.info("1:59:59,定时已删除erpAppkey的缓存");
    }


//    @Scheduled(cron = "0 0 0/59 * * *")
//    public void taskScheduledDelErpAppkey(){
//        log.info("定时执行删除");
//        this.delCacheErpAppkey();
//    }


}

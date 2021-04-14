package com.example.demo.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * redis 工具类
 */
@Slf4j
@Component
public class RedisClient {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;




//    向指定队列发送消息
    public boolean linkPop(String keyname,Object value){
        try {
            redisTemplate.opsForList().leftPush(keyname,value);
            return true;
        } catch (Exception e) {
            log.error("push Key error:{}",e);
            return false;
        }
    }



//    指定队列进行消费消息
    public Object rpop(String keyName){
        try {
            return redisTemplate.opsForList().rightPop(keyName);
        } catch (Exception e) {
            log.error("pop keyName:{} error:{}",keyName,e);
            return false;
        }
    }

    /**
     * 取值 - <brpop：阻塞式> - 推荐使用
     * @param key 键
     * @param timeout 超时时间
     * @param timeUnit 给定单元粒度的时间段
     *                 TimeUnit.DAYS          //天
     *                 TimeUnit.HOURS         //小时
     *                 TimeUnit.MINUTES       //分钟
     *                 TimeUnit.SECONDS       //秒
     *                 TimeUnit.MILLISECONDS  //毫秒
     * @return
     */
    public Object brpop(String key, long timeout, TimeUnit timeUnit) {
        try {
            return redisTemplate.opsForList().rightPop(key, timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查看值
     * @param key 键
     * @param start 开始
     * @param end 结束 0 到 -1代表所有值
     * @return
     */
    public List<Object> lrange(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    /** ---------------------------------- redis消息队列 ---------------------------------- */
}

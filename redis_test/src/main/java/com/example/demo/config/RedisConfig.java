package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
@Slf4j
public class RedisConfig {


    /** redis 服务器地址 */
    @Value("${spring.redis.host}")
    private String host;

    /** redis 端口号 */
    @Value("${spring.redis.port}")
    private int port;

    /** redis 服务器密码 */
    @Value("${spring.redis.password}")
    private String password;

    /** redis 连接池最大连接数(使用负值无限制) */
    @Value("${spring.redis.pool.max-active}")
    private int maxActive;

    /** redis 连接池最大空闲数 */
    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    /** redis 连接池小空闲数 */
    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    /** redis 连接池最大阻塞等待时间(负值无限制) */
    @Value("${spring.redis.pool.max-wait}")
    private int maxWait;

    /** redis 数据库索引(默认0) */
    @Value("${spring.redis.database}")
    private int database;

    /** redis 超时时间 */
    @Value("${spring.redis.timeout}")
    private int timeout;


    @Bean
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxActive);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setMaxWaitMillis(maxWait);
        return config;
    }

    @Bean
    public JedisConnectionFactory getConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(port);
        factory.setPassword(password);
        factory.setDatabase(database);
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        return factory;
    }

    @Bean
    public RedisTemplate<?, ?> getRedisTemplate() {
        JedisConnectionFactory factory = getConnectionFactory();
        RedisTemplate<?, ?> redisTemplate = new StringRedisTemplate(factory);
        return redisTemplate;
    }

}

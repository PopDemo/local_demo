package cn.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnProperty(name = "kafka.consumer.enable", havingValue = "true")
@EnableKafka
public class KafkaConsumerConfig {


    /**
     * 2021.4.27
     * 1. 编写配置类
     * 2. 使用Partition01进行send
     * 3. 使用ConsumerGroup组中的 groupConsumer01进行监听 Partition01,并进行消费
     */




    protected Map<String,Object> getConsumerConfigMaps(){
        Map<String,Object> configParam = new HashMap<>();









        return configParam;
    }




}

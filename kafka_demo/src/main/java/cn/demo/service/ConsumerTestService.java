package cn.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerTestService {
    private final static String TEST_TOPIC = "test";


    @KafkaListener(containerFactory = "KafkaListenerContainerFactory",topicPartitions = {@TopicPartition(topic = TEST_TOPIC,partitions = "1")})
    public void ConsumerTest(ConsumerRecord<?, String> record){
        log.info("topic:{},message:{}",TEST_TOPIC, JSONObject.toJSONString(record));
    }


}

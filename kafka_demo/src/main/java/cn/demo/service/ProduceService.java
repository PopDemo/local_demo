package cn.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Component
@Slf4j
public class ProduceService {

    @Resource
    private KafkaTemplate kafkaTemplate;


    public <T> void Send(String topic,String key,T message) throws Exception{
        log.info("Kafka SendTopic:{},SendKay:{},SendMessage:{}",topic,key,message);
        kafkaTemplate.send(topic,key,message);
        log.info("Kafka SendTopic:{},SendKay:{},发送时间:{}   ->   消息发送成功",topic,key, LocalDateTime.now());
    }


}

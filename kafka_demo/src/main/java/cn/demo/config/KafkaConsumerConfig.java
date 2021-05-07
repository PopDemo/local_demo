package cn.demo.config;

import cn.demo.config.propertiesTO.KafkaConsumerProperties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnProperty(name = "kafka.consumer.enable", havingValue = "true")
@EnableKafka
public class KafkaConsumerConfig {

    @Resource
    private KafkaConsumerProperties kafkaConsumerProperties;

    /**
     * 2021.4.27
     * 1. 编写配置类
     * 2. 使用Partition01进行send
     * 3. 使用ConsumerGroup组中的 groupConsumer01进行监听 Partition01,并进行消费
     */
    protected  ConsumerFactory<String,Object> Create_consumerFactory(){
        Map<String,Object> configParam = new HashMap<>();
        configParam.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConsumerProperties.getServers());
        configParam.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaConsumerProperties.getKeyClass());
        configParam.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaConsumerProperties.getValueClass());
        configParam.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, kafkaConsumerProperties.isEnableAutoCommit());
        configParam.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConsumerProperties.getGroupId());
        //默认游标为最新处 latest earliest
        configParam.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        // return到consumer配置中心
        return new DefaultKafkaConsumerFactory<>(configParam);
    }

    // 创建kafka消费配置
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> KafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(Create_consumerFactory());
        factory.setBatchListener(false);//默认
        Integer concurrency = kafkaConsumerProperties.getConcurrentConsumer();
        if (null != concurrency && concurrency > 0) {
            factory.setConcurrency(concurrency);
        }
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }



}

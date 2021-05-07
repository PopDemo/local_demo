package cn.demo.config;

import cn.demo.config.propertiesTO.KafkaProducerProperties;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnProperty(name = "kafka.produce.enable",havingValue = "true")
public class KafkaProduceConfig {

    @Resource
    private KafkaProducerProperties kafkaProducerProperties;

    protected ProducerFactory<String,Object> CreateProducerFactory(){
        Map<String,Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProducerProperties.getServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaProducerProperties.getKeyClass());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProducerProperties.getValueClass());

        return new DefaultKafkaProducerFactory<>(props);
    }

   @Bean
   public KafkaTemplate<String,String> kafkaTemplate(){
        return  new KafkaTemplate(CreateProducerFactory());
   }



}

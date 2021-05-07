package cn.demo.config.propertiesTO;

import lombok.Data;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka.producer")
@Data
public class KafkaProducerProperties {

    /** 服务器地址信息 */
    private String servers;
    /** key序列化类 */
    private String keyClass = StringSerializer.class.getName();
    /** value序列化类 */
    private String valueClass = StringSerializer.class.getName();
}
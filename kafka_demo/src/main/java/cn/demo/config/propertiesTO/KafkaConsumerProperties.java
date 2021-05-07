package cn.demo.config.propertiesTO;

import lombok.Data;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka.consumer")
@Data
public class KafkaConsumerProperties {

    /** 服务器地址信息 */
    private String servers;
    private String loyaltyServers;
    /** key序列化方式 */
    private String keyClass = StringDeserializer.class.getName();
    /** value序列化类 */
    private String valueClass = StringDeserializer.class.getName();
    /** 是否自动提交 */
    private boolean enableAutoCommit;
    private String groupId;
    //  private String batchListener;
    private Integer concurrentConsumer;


}

package com.example.spring.kafka.test.embedded;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class Config {
  
  @Bean
  public Sender sender() {
    return new Sender();
  }
  
  @Bean
  public Properties properties() {
    return new Properties();
  }

  @Bean
  public Map<String, Object> producerConfigs(Properties properties) {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    return props;
  }

  @Bean
  public ProducerFactory<String, String> producerFactory(Properties properties) {
    return new DefaultKafkaProducerFactory<>(producerConfigs(properties));
  }

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate(Properties properties) {
    return new KafkaTemplate<>(producerFactory(properties));
  }

}

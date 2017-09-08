package com.example.spring.kafka.test.embedded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {
  private static final Logger LOG = LoggerFactory.getLogger(Sender.class);

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void send() {

    String topic = "topic";
    String data = "data";
    String key = "key";

    LOG.info("sending to topic: '{}', key: '{}', data: '{}'", topic, key, data);

    kafkaTemplate.send(topic, key, data);
    
//    kafkaTemplate.send(topic, data);

  }
}
